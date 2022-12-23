/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * It creates an object Entry. 
 * It will be used by the RentMovie class to generate entries 
 * according to the movies rented by the user, and insert them
 * into their History.
 *
 * @author Keith Fernandes 2020353
 */
public class Entry {

    String title;
    Instant rentedAt;
    int timesRented;

    public Entry(String title, Instant rentedAt, int timesWatched) {
        this.title = title;
        this.rentedAt = rentedAt;
        this.timesRented = timesWatched;
    }

    Entry(String title, ZonedDateTime rentedAt, int timesWatched) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTitle() {
        return title;
    }

    public Instant getRentedAt() {
        return rentedAt;
    }

    public int getTimesWatched() {
        return timesRented;
    }

    @Override
    public String toString() {
        return "RentalEntry{" + "title=" + title + ", rentedAt=" + rentedAt + ", timesWatched=" + timesRented + '}';
    }

}
