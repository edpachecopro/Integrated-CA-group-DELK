/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * It prints the error when an invalid input has been received.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayError implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("\nInvalid option, please, try again.");
    }

}
