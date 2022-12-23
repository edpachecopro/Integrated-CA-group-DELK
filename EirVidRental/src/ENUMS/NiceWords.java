/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENUMS;

/**
 * This ENUM holds a list of nice sentences. 
 * These sentences will be displayed to the user 
 * later in the code after they complete a rental.
 * The list can obviously be improved and extended.
 * 
 * @author Douglas Santos 2020338
 */
public enum NiceWords {

    //Sentences
    AWESOME("Awesome!"),
    GREAT("Great!"),
    YOU_GOT_IT("You got it!"),
    YES_BOSS("Yes, boss!"),
    NICE_CHOICE("Nice choice!"),
    I_LOVED_THAT_ONE("I loved that one!"),
    FIVE_STARS("VERY GOOD! 7 out of 5 Stars!"),
    SAM_LIST("That one of Sam's Top 5\n" + "'" + "Movies to take to a desert island." + "'"),
    SPOILER_ALERT("SPOILER ALERT!\nJust kidding, I hate spoilers too!");

    private final String word;

    //Assign the value to the variable sentence
    NiceWords(String word) {
        this.word = word;
    }

    //Get the variable and return it
    public String getWord() {
        return word;
    }
}
