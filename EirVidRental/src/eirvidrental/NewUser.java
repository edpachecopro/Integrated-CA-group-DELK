
package eirvidrental;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Edgard Pacheco
 * Student ID 2020332
 * 
 */

public class NewUser {
    
    String file = "users.txt"; 
    String name;
    String email;
    Boolean found = false;
    Scanner sc = new Scanner(System.in); // Scanner to get input from users
    
    
        public void newAccount() throws FileNotFoundException, IOException{
 
        System.out.println("Enter you first name:");
        name = sc.nextLine();
        
        // validating if is numeric for name
        if (name.matches("[A-Za-z]*")){
            System.out.println("Enter you email:");
            email = sc.nextLine().toLowerCase();
        }else{
            System.out.println("\nPlease enter a valid name!\n");
            newAccount();
        }    
        // validating if there is @ for email    
        if (email.contains("@")){
                
        String[] newuser = { name + ",", email + "\n"}; // array with name and email 
        
        try  {
           
         // creating BufferedWriter to write on users.txt
         BufferedWriter write = new BufferedWriter(new FileWriter(new File(file),true));   

         for (String user : newuser){
             write.write(user); // writing the name and email
         }
         
        write.close(); // closing file users.txt
        
        System.out.println("\nCongratulations " + name + ", your account has been successfully created!\n");
           MainMenu callmenu = new MainMenu();
           callmenu.MainMenu(name,email);
            
            
        }catch(FileNotFoundException e){
            System.out.println("Error when creating a new user");
        }
        
        }else{
             System.out.println("\nPlease enter a valid email address!\n");
             newAccount();
        }

    }
    
}



