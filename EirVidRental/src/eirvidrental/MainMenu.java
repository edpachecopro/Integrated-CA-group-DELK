/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidrental;

import MenuDisplays.MenuDisplayError;
import MenuDisplays.MenuDisplayFarewellMain;
import MenuDisplays.MenuDisplayHorizontal;
import MenuDisplays.MenuDisplayMainHeader;
import MenuDisplays.MenuDisplayVertical;
import java.util.Scanner;

/**
 * Main Menu of the program that will be calling all of the other specific classes.
 * 
 * @author Douglas Santos 2020338
 */
public class MainMenu {

    public void MainMenu(String user, String email) {

        Scanner read = new Scanner(System.in);

        System.out.println("Press enter to access Menu");
        read.nextLine();
        // Displays the main header
        MenuDisplayMainHeader mainHeader = new MenuDisplayMainHeader();
        mainHeader.Menu();
        // Display the initial menu
        MenuDisplayHorizontal main = new MenuDisplayHorizontal();
        main.Menu();
        // After that, it will display the main menu vertically
        MenuDisplayVertical menuVertical = new MenuDisplayVertical();

        //It only exits the program when the user types 5, which is the Exit option in the menu
        String choice = "";
        while (!choice.equals("5")) {

            // prompt user to enter their choice
            choice = read.nextLine();

            try {
                switch (choice) {
                    case "1":
                        //Option 1 Recommendations

                        //Brings the vertical menu
                        menuVertical.Menu();
                        break;
                    case "2":
                        //Option 2 Search Movie
                        //Call the SearchMovie class

                        //Brings the vertical menu
                        menuVertical.Menu();
                        break;
                    case "3":
                        //Option 3 Rent a movie
                        //Access the renting menu 

                        //Brings the vertical menu
                        menuVertical.Menu();
                        break;
                    case "4":
                        //Option 4 History
                        //Access the rental history of the user if they have one

                        //Brings the vertical menu
                        menuVertical.Menu();
                        break;

                    case "5":
                        //Exits the program 
                        MenuDisplayFarewellMain farewell = new MenuDisplayFarewellMain();
                        //and displays a farewell message
                        farewell.Menu();
                        break;
                    default:
                        //Catches anything that is not in the menu
                        MenuDisplayError error = new MenuDisplayError();
                        error.Menu();
                        //Returns the user to the menu again until the choose a valid option
                        menuVertical.Menu();
                        break;

                }

            } catch (Exception e) {
                System.out.println("An error occured: " + e);
            }

        }

    }

}
