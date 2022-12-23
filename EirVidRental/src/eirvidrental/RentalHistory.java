/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


/**
 * This class shows a history of the movies the user has rented.
 * If the user doesn't have a history yet it will create one for them.
 * 
 * @author Keith Fernandes 2020353
 */
public class RentalHistory {

    void showHistory(String user) throws FileNotFoundException, IOException {

        // Check if the user has a rental history file
        File historyFile = new File(user + "_userHistory.csv");
        Map<String, Entry> rentalHistory = new HashMap<>();
        if (historyFile.exists()) {
            // If the file exists, read the rental history into a map
            // with the movie title as the key and an Entry object as the value
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

        //Prints the list of movies that have been rented by the user
        //Creates a date formater to display the date in a certain pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n - - - - History of movies rented - - - - \n");
        //It iterates over the values of rentalHistory map and for each entry in the map
        //It converts the date to string and prints the other information such as Title and Times rented
        rentalHistory.values().forEach((entry) -> {
            String dateString = entry.rentedAt.atZone(ZoneId.systemDefault()).format(formatter);
            System.out.printf("  - %s: rented %d time(s). Last time rented on %s %n", entry.title, entry.timesRented, dateString);
        });

    }

}
