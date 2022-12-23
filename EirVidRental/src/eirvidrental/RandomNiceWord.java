/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import ENUMS.NiceWords;
import Interfaces.GetRandomWordInterface;
import java.util.Random;

/**
 * It uses a getRandomWord to retrieve a random nice word.
 * It takes the words from an ENUM.
 * 
 * @author Douglas Santos 2020338
 */
public class RandomNiceWord implements GetRandomWordInterface{

    @Override
    public String getRandomWord() {
        NiceWords[] words = NiceWords.values();
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        return words[index].getWord();
    }
    
}
