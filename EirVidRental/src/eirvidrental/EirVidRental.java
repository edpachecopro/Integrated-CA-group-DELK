/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;
import MenuDisplays.MenuDisplayMainHeader;
import MenuDisplays.MenuDisplayStartInstructions;
import MenuDisplays.MenuDisplayWelcome;
import java.util.Scanner;

/**
 *
 * @author Douglas Santos 2020338
 */
public class EirVidRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner read = new Scanner(System.in);
        
        //Call Welcome banner
        MenuDisplayWelcome welcome = new MenuDisplayWelcome();
        welcome.Menu();
        //Call Main Header
        MenuDisplayMainHeader header = new MenuDisplayMainHeader();
        header.Menu();
        //Call User instructions
        MenuDisplayStartInstructions instruction = new MenuDisplayStartInstructions();
        instruction.Menu();
        //Wait for the user to enter something
        read.nextLine();
        //Method to call login here

    }
}
