package ui;

import java.util.Scanner;
import services.AuthService;

public class HomeMenu {
    public void showMenu() {
        System.out.println("==========================");
        System.out.println("1. Register ");
        System.out.println("2. Login ");
        System.out.println("3. Exit");
        System.out.println("===========================================");


       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your choice");
        int choice =  sc.nextInt();

        switch (choice) {
            case 1 :
              System.out.println("Enter your full name");
              String fullName = sc.next();
              System.out.println("Enter your email");
              String email = sc.next();
              System.out.println("Enter your password , password must less than 6 characters");
              String password = sc.next();
              System.out.println("Enter your address");
              String address = sc.next();

              new AuthService().Register(fullName ,email,password,address);
              break;
           case 2 :
               new AuthService().Login();
               break;
           case 3 :
               System.exit(0);
               break;

           default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
