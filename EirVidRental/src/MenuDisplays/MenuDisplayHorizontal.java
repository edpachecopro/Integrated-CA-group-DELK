/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * It displays the main menu in horizontal orientation.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayHorizontal implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("Choose an option:");
        System.out.println("1. Recommendations");
        System.out.println("2. Movie search");
        System.out.println("3. Rent a movie");
        System.out.println("4. Your rental history");
        System.out.println("5. Exit");
        System.out.println("\n ----------------------------- \n ");
    }

}
