/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

/**
 *It creates an object Movie.
 * The object is used by other classes when they need to create a movie object.
 * 
 * @author Douglas Santos 2020338
 */

//It implements comparable because we will be comparing the popularity to
//recommend the most rented movies
public class Movie implements Comparable<Movie> {

    final String id;
    final String title;
    int popularity;
    final String runtime;
    final double price;
    final String overview;
    final String paragraph;

    public Movie(String id, String title, int popularity, String runtime, double price, String overview, String paragraph) {
        this.id = id;
        this.title = title;
        this.popularity = popularity;
        this.runtime = runtime;
        this.price = price;
        this.overview = overview;
        this.paragraph = paragraph;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getRuntime() {
        return runtime;
    }

    public double getPrice() {
        return price;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getOverview() {
        return overview;
    }
    
    //This will print the movie object variables when prompted
    @Override
    public String toString() {
        return title + "\nID: " + id
                + "\n -- Overview --\n" + paragraph + "\n- - - - - - - - -"
                + "\nWatched: " + popularity + " Times\n"
                + "Duration: " + runtime + " minutes\n"
                + "Price: €" + price + "\n- - - - - - - - -\n";
    }

    //This method will be used to compare the popularity of movies

    @Override
    public int compareTo(Movie comparison) {
        return this.popularity - comparison.popularity;
    }
}

