/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import ENUMS.OtherSentences;
import Interfaces.GetRandomWordInterface;
import java.util.Random;

/**
 ** It uses a getRandomWord to retrieve a random nice word. 
 * It takes the words from an ENUM.
 *
 * @author Douglas Santos 2020338
 */
public class RandomSentence implements GetRandomWordInterface {

    @Override
    public String getRandomWord() {
        Random random = new Random();
        OtherSentences[] values = OtherSentences.values();
        return values[random.nextInt(values.length)].getSentence();
    }
}
