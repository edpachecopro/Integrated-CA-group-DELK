/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuDisplays;

import Interfaces.MenuDisplayInterface;

/**
 * It displays the main menu in vertical orientation.
 *
 * @author Douglas Santos 2020338
 */
public class MenuDisplayHorizontal implements MenuDisplayInterface {

    @Override
    public void Menu() {
        System.out.println("\nMENU: 1. Recommendations | 2. Search | 3. Rent | 4. History | 5. Exit ");
    }

}
