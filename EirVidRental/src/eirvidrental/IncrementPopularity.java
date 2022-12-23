/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * It increments the popularity of a movie. It will be used the the RentMovie
 * class every time a user rents a movie to keep the Recommendations up to date.
 *
 * @author Keith Fernandes 2020353
 */
public class IncrementPopularity {

    //It will print to a csv file
    private static final String CSV_FILE = "movies.csv";

    public void incrementPopularity(String movieTitle) throws IOException {
        //Creates the list of movies in a map like the lisfOfMovies class does
        ListOfMovies moviesToSort = new ListOfMovies();
        Map<String, Movie> movies = moviesToSort.ListOfMovies();

        //Increments the variable that holds the movie popularity value
        for (Movie movie : movies.values()) {
            if (movie.title.equals(movieTitle)) {
                movie.popularity++;
                break;
            }
        }
        //Updates the popularity, by print the new valuesof the movie.
        //In this case only the popularity will change
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            writer.println("id,title,popularity,runtime,price,overview");
            movies.values().forEach((movie) -> {
                writer.println(movie.id + "," + movie.title + "," + movie.popularity + "," 
                        + movie.runtime + "," + movie.price + "," + movie.overview);
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
