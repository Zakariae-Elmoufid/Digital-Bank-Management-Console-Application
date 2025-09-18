package ui;


import model.Account;
import model.User;
import repositories.AccountRepository;
import repositories.UserRepository;
import services.AccountService;
import services.AuthService;
import util.Session;

import java.util.List;
import java.util.Scanner;

public class HomeMenu {

    public void showMenu(){
         UserRepository userRepository = new UserRepository();
         AuthService authService = new AuthService(userRepository);
         AccountRepository accountRepository = new AccountRepository();
         AccountService accountService = new AccountService(accountRepository);




        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Session session =  Session.getInstance();

        do{
            System.out.println("=========== Hello back "+session.getUserId()+ "---------"  +session.getFullName() +"---"+session.getEmail()  +  "------"+ session.getAddress() +"----- ======================");
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
                case 1:
                    System.out.println("if you confirm creation your account: ");
                    System.out.println("1. I confirm ");
                    System.out.println("2. cancel ");

                    int choice1 = sc.nextInt();
                    if(choice1 == 1){
                        boolean isCreated = accountService.createAccount(session.getUserId());
                        if(isCreated){
                            System.out.println("Account created successfully");
                        }else{
                            System.out.println("Account creation failed");
                        }

                    }else {
                        break;
                    }
                    break;
                case 2:
                    System.out.println("My Account List");
                    List<Account> acccounts = accountService.listAccount();
                    acccounts.forEach(System.out::println);
                case 6:
                    String email = session.getEmail();
                    String address = session.getAddress();
                    System.out.println("========= select what info you want to update ==========");
                    System.out.println("1. your email " + email);
                    System.out.println("2. your Address " + address);
                    int choice6;
                    do {
                    System.out.print("....");
                     choice6 = sc.nextInt();
                    sc.nextLine();
                    if (choice6 == 1) {
                        System.out.println("Enter new email: ");
                        email = sc.nextLine();
                    } else if (choice6 == 2) {
                        System.out.println("Enter new address: ");
                        address = sc.nextLine();
                    }
                    System.out.println("--- would you confirm or continue changing  other info ?");
                    System.out.println("0.if you continue");
                    System.out.println("9.if you confirm change ");
                    choice6 =  sc.nextInt();
                    sc.nextLine();
                    }while(choice6 == 0);

                    User user =  authService.updateProfile(email, address);
                    if(user != null){
                        System.out.println("Your profiel has been up successfully");
                    }
                    break;
                case 7:
                    String newPassword;
                    System.out.println("Entre your old password: ");
                    String oldPassword = sc.nextLine();
                    sc.nextLine();
                    do {
                    System.out.println("Enter new password: ");
                     newPassword = sc.nextLine();
                    }while(newPassword.length() < 6);

                    System.out.println("Your new password: " + newPassword);


                    boolean isChanged = authService.changePassword(oldPassword, newPassword);

                    if (isChanged) {
                        System.out.println("Password has been changed successfully");
                    }else{
                        System.out.println("you have a probleme in your password");
                        choice = 7;
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(true);


    }
}
