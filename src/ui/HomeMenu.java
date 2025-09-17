package ui;


import util.Session;

import java.util.Scanner;

public class HomeMenu {

    public void showMenu(){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Session session =  Session.getInstance();

        do{
            System.out.println("=========== Hello back "+session.getAttribute("email")    +" ======================");
            System.out.println("1. Create account ");
            System.out.println("2. List my accounts ");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction history");
            System.out.println("6. Update profile");
            System.out.println("7. Change password");
            System.out.println("8. Close account");
            System.out.println("9. Logout");
            System.out.println("10. Exit");
            System.out.println("========================================");

        }while(choice > 10);


    }
}
