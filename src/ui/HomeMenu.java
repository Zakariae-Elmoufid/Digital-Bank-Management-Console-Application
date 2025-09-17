package ui;


import model.User;
import repositories.UserRepository;
import services.AuthService;
import util.Session;

import java.util.Scanner;

public class HomeMenu {

    public void showMenu(){
         UserRepository userRepository = new UserRepository();
         AuthService authService = new AuthService(userRepository);

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Session session =  Session.getInstance();

        do{
            System.out.println("=========== Hello back "+session.getAttribute("fullName") +"---"+session.getAttribute("email")  +  "------"+ session.getAttribute("address") +"----- ======================");
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

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 6:
                    String email = session.getAttribute("email");
                    String address = session.getAttribute("address");
                    System.out.println("========= select what info you want to update ==========");
                    System.out.println("1. your email " + email);
                    System.out.println("2. your Address " + address);
                    int choice2;
                    do {
                    System.out.print("....");
                     choice2 = sc.nextInt();
                    sc.nextLine();
                    if (choice2 == 1) {
                        System.out.println("Enter new email: ");
                        email = sc.nextLine();
                    } else if (choice2 == 2) {
                        System.out.println("Enter new address: ");
                        address = sc.nextLine();
                    }
                    System.out.println("--- would you confirm or continue changing  other info ?");
                    System.out.println("0.if you continue");
                    System.out.println("9.if you confirm change ");
                    choice2 =  sc.nextInt();
                    sc.nextLine();
                    }while(choice2 == 0);

                    User user =  authService.updateProfile(email, address);
                    if(user != null){
                        System.out.println("Your profiel has been up successfully");
                    }
                    break;
                case 7:
                    System.out.println("Entre your old password: ");
                    String oldPassword = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter new password: ");
                    String newPassword = sc.nextLine();
                    do{
                    System.out.println("Your new password: " + newPassword);
                    }while (newPassword.length() > 6);

                    boolean isChanged = authService.changePassword(oldPassword, newPassword);

                    if (isChanged) {
                        System.out.println("Password has been changed successfully");
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(true);


    }
}
