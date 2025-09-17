package ui;

import repositories.UserRepository;
import services.AuthService;
import model.User;
import util.Session;

import java.util.Scanner;

public class AccountMenu {
    private UserRepository userRepository = new UserRepository();
    private AuthService authService = new AuthService(userRepository);
    private Session session  ;

    public void showMenu() {

        int choice;
        session = new Session();
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("==========================");
            System.out.println("1. Register ");
            System.out.println("2. Login ");
            System.out.println("3. Exit");
            System.out.println("===========================================");


            System.out.println("Enter your choice");

            choice = sc.nextInt();
            sc.nextLine();
            String fullName;
            String email;
            String password;
            String address;
            switch (choice) {
                case 1:
                    System.out.println("Enter your full name");
                    fullName = sc.nextLine();
                    do {
                        System.out.println("Enter your email");
                        email = sc.nextLine();

                        if (authService.findUserByEmail(email) != null) {
                            System.out.println("Email already exists , please try another email");
                        }
                    }while (authService.findUserByEmail(email) != null);
                    do {
                        System.out.println("Enter your password ");
                        password = sc.nextLine();
                        if (password.length() < 6) {
                            System.out.println("Password must be at least 6 characters, try again");
                        }
                    }while (password.length() < 6);
                    System.out.println("Enter your address");
                    address = sc.nextLine();


                    User isCreated = this.authService.Register(fullName, email, password, address);
                    if (isCreated != null) {
                        System.out.println("Account created successfully");
                    } else {
                        System.out.println("Registration failed. Try again.");
                    }
                    break;
                case 2:
                    User user ;
                    do{
                    System.out.println("Enter your email");
                    email = sc.nextLine();
                    System.out.println("Enter your password ");
                    password = sc.nextLine();

                   user = this.authService.Login(email, password);
                        if (user == null) {
                            System.out.println("email or password is wrong , please try again");
                        }
                    }while (user == null);

                    session = Session.getInstance();
                    session.setAttribute("fullName", user.getFullName());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("address", user.getAddress());
                    session.setAttribute("password", user.getPassword());
                    new HomeMenu().showMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (session.getAttribute("email") == null);
    }
}
