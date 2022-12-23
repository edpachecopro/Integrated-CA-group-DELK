package eirvidrental;

import MenuDisplays.MenuDisplayError;
import MenuDisplays.MenuDisplayVerticalLogin;
import MenuDisplays.MenuDisplayFarewellLogin;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author edgardpacheco
 */
public class Login {

    String file = "users.txt";
    String name;
    String email;
    Boolean found = false;
    Scanner sc = new Scanner(System.in); // Scanner to get input from users

    private static Scanner checkUser; // Scanner to get the data from users.txt

    void checkLogin() {

        System.out.println("Please enter you email to login: ");
        Scanner sc = new Scanner(System.in);
        String userin = sc.nextLine(); // getting users input

        try {

            checkUser = new Scanner(new File(file)); // loading the file users.txt
            checkUser.useDelimiter("[,\n]"); // using , as delimiter to search if exist the user inside the file

            while (checkUser.hasNext() && !found) { // searching if exist the user on users.txt

                name = checkUser.next();
                email = checkUser.next();

                if (email.equals(userin)) {
                    found = true;

                    System.out.println("\n☴☴☴ Welcome " + name.substring(0, 1)
                            .toUpperCase() + name.substring(1) + " ☴☴☴");
                    MainMenu callmenu = new MainMenu();
                    callmenu.MainMenu(name, email);
                    System.exit(0);

                }

            }
            if (found == false) {
                System.out.println("Sorry, user not found. Do you want create an account\n");

                MenuDisplayVerticalLogin menuV = new MenuDisplayVerticalLogin();
                menuV.Menu();
                System.out.println("⇣⇣");
                Scanner input = new Scanner(System.in);
                String choice = input.nextLine();

                switch (choice) { // giving 2 option to if the users doesn't exist
                    case "1":
                        NewUser newuser = new NewUser();
                        newuser.newAccount();
                        break;
                    case "2":
                        MenuDisplayFarewellLogin farewell = new MenuDisplayFarewellLogin();
                        farewell.Menu();
                        System.exit(0);
                    default:
                        MenuDisplayError error = new MenuDisplayError();
                        error.Menu();
                        LoginMenu checkuser = new LoginMenu();
                        checkuser.Login();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
        }

    }

}
