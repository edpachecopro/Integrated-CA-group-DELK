/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import MenuDisplays.MenuDisplayMainHeader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * It searches movies in a movie map and return any match with a given query.
 *
 * @author Douglas Santos
 */
public class SearchMovie {

    public void search() throws IOException {
        
        //Creates a list of movies into a map
        ListOfMovies moviesToSort = new ListOfMovies();
        Map<String, Movie> movies = moviesToSort.ListOfMovies();
        Scanner read = new Scanner(System.in);
        boolean found = false;

        MenuDisplayMainHeader header = new MenuDisplayMainHeader();
        header.Menu();
        System.out.println(" - - - - Movie Search - - - - ");
        System.out.println("Type the title (or words of a title)\n");

        String choice = read.nextLine();

        // Check if the user entered a blank string or only whitespace characters
        while (choice.trim().isEmpty()) {
            // If the user entered a blank string or only whitespace characters, displays an error message and prompts the user again
            System.out.println("You must enter a valid search query");
            System.out.println(" - - - - Movie Search - - - - ");
            System.out.println("Type the title (or words of a title)\n");
            choice = read.nextLine();
        }//Splits the query if there's more than one word
        String[] words = choice.toLowerCase().split("\\s+");
        header.Menu();
        System.out.println("\nSearch results for: "
                + "["+ choice.toUpperCase()+"]" +"\n ");

        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            // Get the current movie
            Movie movie = entry.getValue();

            for (String word : words) {
                // Check if the movie's title contains the query
                if (movie.getTitle().toLowerCase().contains(word)) {
                    // Print the movie's title if it contains the query
                    found = true;
                    if (found) {
                        System.out.println("/\\");
                        System.out.println("\\/'");
                        System.out.println("(( '");
                        System.out.println(" )) '");
                        System.out.println(" (   '");
                        System.out.println("      '");
                        System.out.println(movie.toString());
                    }
                }
            }
            
        }
        System.out.println("Check your search results above! "
                    + "\nMake note of the ID of the movie you want to rent.");

        if (!found) {
            System.out.println("No movies found matching your search.\nPlease, try again.");
        }
    }
}
