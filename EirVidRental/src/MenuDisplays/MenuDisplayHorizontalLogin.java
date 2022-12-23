/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 *It displays the main menu in vertical orientation.
 * Exclusive for the login menu.
 * 
 * @author Douglas Santos 2020338
 */
public class MenuDisplayHorizontalLogin implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("Choose an option:");
        System.out.println("1. Login | 2. Create Account | 3. Exit");
    }

}
