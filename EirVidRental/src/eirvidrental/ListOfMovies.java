/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Creates and returns a list of all the movies. The list is inside a Map.
 *
 * @author Douglas Santos 2020338
 */
public class ListOfMovies {

    public Map<String, Movie> ListOfMovies() throws FileNotFoundException, IOException {
        //It will be using a csv movies file, the program will be using a espefic patter to compile it
        //so we garantee to read the comas withing commas.
        String csvFile = "movies.csv";
        Pattern p = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        //Creates a map to receive the movies
        Map<String, Movie> movies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line = reader.readLine();  // skip the header so it won't read the titles of the rows
            while ((line = reader.readLine()) != null) {
                String[] parts = p.split(line);
                String id = parts[0];
                String title = parts[1];
                int popularity = Integer.parseInt(parts[2]);
                String runtime = parts[3];
                double price = Double.parseDouble(parts[4]);
                ParagraphMaker lineToParagraph = new ParagraphMaker();
                String overview = parts[5];
                String paragraph = lineToParagraph.maker(overview);

                //Create the movie object and add it to the map
                movies.put(id, new Movie(id, title, popularity, runtime, price, overview, paragraph));

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return movies;
    }

}
