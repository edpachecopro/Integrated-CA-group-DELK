/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENUMS;

/**
 * This ENUM holds a list of encouraging sentences.
 * These sentences will be displayed to the user later
 * in the code when the decide not to rent a movie.
 * The list can obviously be improved and extended.
 * 
 * @author Douglas Santos 2020338
 */
public enum OtherSentences {
    
    //Sentences
    OK_TRY_AGAIN("Ok, let's try again!"),
    NO_PROBLEM_KEEP_LOOKING("No problem, let's keep looking."),
    HEY_ANOTHER_SEARCH("Hey! Another search, I say!"),
    COPY_CODE("You can use CRTL+C, CTRL+V to copy and paste the code. ;)"),
    LETS_GO_AGAIN("Let's go, again, then.");

    private final String sentence;
    
    //Assign the value to the variable sentence
    OtherSentences(String sentence) {
        this.sentence = sentence;
    }
    
    //Get the variable and return it
    public String getSentence() {
        return sentence;
    }

}
