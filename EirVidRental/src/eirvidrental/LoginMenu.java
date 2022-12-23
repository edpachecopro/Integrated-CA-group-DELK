package eirvidrental;

import MenuDisplays.MenuDisplayError;
import MenuDisplays.MenuDisplayMainHeader;
import MenuDisplays.MenuDisplayVerticalLogin;
import MenuDisplays.MenuDisplayFarewellLogin;
import java.util.Scanner;

/**
 *
 * @author Edgard Pacheco
 * Student ID 2020332
 * 
 */

public class LoginMenu {

    public void Login() {

        Scanner read = new Scanner(System.in);
        String choice = "";

        // display menu with options to list movies or select one by id
        MenuDisplayMainHeader mainHeader = new MenuDisplayMainHeader();
        mainHeader.Menu();
        MenuDisplayVerticalLogin menuLogin = new MenuDisplayVerticalLogin();
        menuLogin.Menu();

        // prompt user to enter their choice
        choice = read.nextLine();

        try {

            switch (choice) {

                case "1":
                    Login gologin = new Login();
                    gologin.checkLogin();
                    break;

                case "2":
                    NewUser gouser = new NewUser();
                    gouser.newAccount();
                    break;

                case "3":
                    MenuDisplayFarewellLogin farewell = new MenuDisplayFarewellLogin();
                    farewell.Menu();
                    break;

                default:
                    MenuDisplayError error = new MenuDisplayError();
                    error.Menu();
                    Login();
                    break;

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
