/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import MenuDisplays.MenuDisplayMainHeader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author lucas
 */
public class Recommendations {
    
public void recommendations() throws IOException {
        ListOfMovies moviesToSort = new ListOfMovies();
        Map<String, Movie> movies = moviesToSort.ListOfMovies();
        // Sort movies by popularity in descending order
        //Creates a new map and keeps a list of sorted movies by their popularity in descending order
        
        Map<String, Movie> sortedMovies;
        sortedMovies = movies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Output the top 5 movies
        
        MenuDisplayMainHeader header = new MenuDisplayMainHeader();
        header.Menu();
        System.out.println("- - Recommendations - -\nThese are the most rented movies"
                + " in our catalog."
                + "\nWe thought you might give them a try.\n*   *   *   *   *");
        //Counter to keep track of the ranking number
        AtomicInteger count = new AtomicInteger(1);
        //It prints the result of the sorting, displaying also their ranking
        sortedMovies.entrySet().stream().limit(5)
                .forEach((entry) -> System.out.println(count.getAndIncrement()
                + ") " + entry.getValue().toString()));
        System.out.println("Check your recommendations above!");
        

    }

}
