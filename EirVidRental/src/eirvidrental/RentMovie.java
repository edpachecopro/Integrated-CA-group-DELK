/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import MenuDisplays.MenuDisplayMainHeader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class will find the movie the user wants and rent it.
 * It will use the movie ID to find the movie in a list of movies.
 * 
 * @author Keith Fernandes 2020353
 */
public class RentMovie {

    public void rent(String user) throws FileNotFoundException, IOException {

        // Read the movies.csv file and store the information in a map
        // with the movie id as the key and a Movie object as the value
        ListOfMovies list = new ListOfMovies();
        Map<String, Movie> movies = list.ListOfMovies();
        IncrementPopularity increment = new IncrementPopularity();
        List<Movie> rentedMovies = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        //ADDRentalHistory
        // Check if the user has a rental history file
        File historyFile = new File(user + "_userHistory.csv");
        Map<String, Entry> rentalHistory = new HashMap<>();
        if (historyFile.exists()) {
            // If the file exists, read the rental history into a map
            // with the movie title as the key and a RentalEntry object as the value
            try (BufferedReader reader = new BufferedReader(new FileReader(historyFile))) {
                String line = reader.readLine();  // skip the header row
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String title = parts[1];
                    Instant rentedAt = Instant.parse(parts[2]);
                    int timesWatched = Integer.parseInt(parts[3]);
                    rentalHistory.put(title, new Entry(title, rentedAt, timesWatched));
                }
            }
        }
        boolean rent = true;
        // Continue renting movies until the user decides to stop
        MenuDisplayMainHeader header = new MenuDisplayMainHeader();
        header.Menu();
        while (rent) {
            // Ask the user for the movie id
            System.out.println("\n - - - - Choose your movie - - - - ");
            System.out.print("Enter the id of the movie you want to rent (or 'q' to quit):\n");
            String movieId = read.nextLine().toUpperCase();
            // Get the movie information from the movies map
            if (movieId.equalsIgnoreCase("q")) {
                RandomSentence nay = new RandomSentence();
                System.out.println(nay.getRandomWord());
                break;
            }

            Movie movie = movies.get(movieId);
            if (movie == null && !movieId.equalsIgnoreCase("b")) {
                System.out.println("Invalid movie id");
                continue;
            }

            // Check if the movie is in the rental history
            Entry entry = rentalHistory.get(movie.title);
            if (entry != null) {
                // If the movie was rented within the last minute, don't allow the rental
                if (Instant.now().isBefore(entry.rentedAt.plus(1, ChronoUnit.MINUTES))) {
                    System.out.println("You cannot rent the same movie within 1 minute of the previous rental");
                    continue;
                }
            }

            /** - One idea of extra implementation considering different amount of times.
             * 
             * int rentalDuration = 60; // 1 hour in minutes 
             * if(Instant.now().isBefore(entry.rentedAt.plus(rentalDuration,ChronoUnit.MINUTES))) 
             * { System.out.println("You cannot rent the same movie within the hour of the previous rental"); 
             * continue; 
             * }
             * 
             * if we want to change that to days, weeks, all we have to do is multiply the duration-
             * int rentalDuration = 60 * 24 * 7; // 1 week in minutes
             *  - and change the output accordingly.
             * 
             */
            
            
            // Display the movie information and ask the user to confirm
            System.out.println("\n- Summary: (Confirmation Required!)");
            System.out.println("Title: " + movie.title);
            System.out.println("Price: " + movie.price);
            System.out.print("Is this the movie you want to rent? (Y/N): ");
            String confirmation = read.nextLine();
            if (!confirmation.equalsIgnoreCase("y")) {
                continue;
            }

            // Rent the movie
            Instant rentedAt = Instant.now();
            if (entry != null) {
                entry.rentedAt = rentedAt;
                entry.timesRented++;
            } else {
                rentalHistory.put(movie.title, new Entry(movie.title, rentedAt, 1));
            }
            rentedMovies.add(movie);

            System.out.println("\nSuccess! You rented your movie!");
            RandomNiceWord yay = new RandomNiceWord();
            System.out.println(yay.getRandomWord());
            // Write the updated rental history to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(historyFile))) {
                writer.println("user,title,day of rental,times watched");
                for (Entry e : rentalHistory.values()) {
                    writer.printf("%s,%s,%s,%d%n", user, e.title, e.rentedAt, e.timesRented);
                }
            }

            increment.incrementPopularity(movie.title);
        }
        header.Menu();
        System.out.println("- Rental summary:");
        double totalPrice = 0;
        for (Movie movie : rentedMovies) {
            System.out.println("Title: " + movie.title + ": " + movie.price);
            totalPrice += movie.price;
        }
        System.out.println("Total price: " + totalPrice);
        if (totalPrice != 0.0) {
            System.out.println("- - Enjoy your movie(s)! - -");
        }

    }
}
