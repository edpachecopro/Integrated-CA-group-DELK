/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

/**
 * It will break the overview line into smaller 10-word lines. It basically does
 * what it says, change a full line into a small paragraph and returns that.
 *
 * @author dacsa
 */
public class ParagraphMaker {

    public String maker(String overview) {

        //Creates and array to receive the separate words
        String[] words = overview.split(" ");
        int counter = 0;
        //A StringBuilder to append word by word and create new sentences
        StringBuilder paragraph = new StringBuilder();
        for (String word : words) {
            // Append the word to the string builder
            paragraph.append(word).append(" ");
            // Increment the counter
            counter++;
            // If the counter is divisible by 10, add a line break
            if (counter % 10 == 0) {
                paragraph.append(System.lineSeparator());
            }
        }
        return paragraph.toString();
    }

}
