/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * A welcome banner for the first time the user enters the program.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayWelcome_1 implements MenuDisplayInterface {

    @Override
    public void Menu() {
        //Very simple way to make these output adaptable  
        //for example " Welcome - Xmas Time" or 
        //" Spooky Season - Check out some Horror Titles"
        System.out.println("☴☴☴☴☴☴  Welcome ☴☴☴☴☴☴☴ ");
    }

}
