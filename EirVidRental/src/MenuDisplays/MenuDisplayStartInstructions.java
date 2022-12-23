/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * It prints the first instructions.
 * In this case, it prompts the user to press 'enter' to
 * have access to the menu.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayStartInstructions implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("/\\");
        System.out.println("\\/'");
        System.out.println("(( '");
        System.out.println(" )) '");
        System.out.println(" (   '");
        System.out.println("      ' Press Enter to start");
        System.out.println("(For a better user experience, "
                + "\nmaximize your console, please) \n ");
        System.out.println("-----------------------------");
    }

}
