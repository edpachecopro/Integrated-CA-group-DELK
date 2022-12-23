/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * It prints a farewell message. For the login class.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayFarewellLogin implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("\nThank you for your visit ☻!\nSee you soon.");
    }

}
