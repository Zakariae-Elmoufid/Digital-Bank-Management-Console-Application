package ui;


import model.Account;
import model.Transaction;
import model.User;
import repositories.AccountRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;
import services.AccountService;
import services.AuthService;
import services.TransactionService;
import util.Session;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HomeMenu {

    public void showMenu(){
         UserRepository userRepository = new UserRepository();
         AuthService authService = new AuthService(userRepository);
         AccountRepository accountRepository = new AccountRepository();
         AccountService accountService = new AccountService(accountRepository);
         TransactionRepository transactionRepository = new TransactionRepository();
         TransactionService transactionService = new TransactionService(transactionRepository);




        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Session session =  Session.getInstance();

        do{
            System.out.println("=========== Hello back "+session.getUserId()+ "---------"  +session.getFullName() +"---"+session.getEmail()  +  "------"+ session.getAddress() +"----- ======================");
            System.out.println("1. Create account ");
            System.out.println("2. List my accounts ");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Update profile");
            System.out.println("7. Change password");
            System.out.println("8. Transaction history");
            System.out.println("9. Close account");
            System.out.println("10. Logout");
            System.out.println("11. Exit");
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
                    break;
                case 3:
                    System.out.println("Enter your deposit amount: ");
                    BigDecimal amount =  sc.nextBigDecimal();

                        acccounts = accountService.listAccount();
                        acccounts.forEach(System.out::println);
                        System.out.println("Enter your rib account : ");
                        String ribAccount = sc.next();
                        Account account = accountService.verifyRib(ribAccount);
                        if(account != null){
                            boolean isdiposit = transactionService.deposit(amount,account);
                            if(isdiposit){
                                System.out.println("Account successfully deposited");
                            }
                            else {
                                System.out.println("Account failed");
                            }
                        }else {
                            System.out.println("Account not found");
                        }

                    break;
                case 4:
                    System.out.println("Enter your Withdraw amount: ");
                    BigDecimal withdrawAmount = sc.nextBigDecimal();
                    acccounts = accountService.listAccount();
                    acccounts.forEach(System.out::println);
                    System.out.println("Enter your rib account : ");
                    String ribAccountWithdraw = sc.next();
                    Account acc = accountService.verifyRib(ribAccountWithdraw);
                    if(acc != null){
                        boolean isWithdraw = transactionService.withdraw(withdrawAmount,acc);
                        if(!isWithdraw){
                            System.out.println("Account withdraw failed");
                        }
                        System.out.println("Account successfully deposited");

                    }else {
                        System.out.println("Account not found");
                    }

                     break;
                case 5:
                    System.out.println("Enter amount to transfer");
                    BigDecimal transferAmount = sc.nextBigDecimal();
                    sc.nextLine();
                    System.out.println("Enter RIB TransferOut :");
                    String TransferOut = sc.nextLine();

                    System.out.println("Enter RIB TransferIn :");
                    String ribTransferIn = sc.nextLine();

                    System.out.println("Enter description :");
                    String description = sc.nextLine();

                    Account fromAccount = accountService.verifyRib(TransferOut);
                    Account  toAccount = accountService.verifyRib(ribTransferIn);


                    boolean isTransfer = transactionService.transfer(fromAccount, toAccount , transferAmount ,description);
                    if(isTransfer){
                        System.out.println("Account successfully transfered");
                    }
                    else{
                        System.out.println("Account transfered failed");
                    }
                   break;


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
                        System.out.println("Your profile has been up successfully");
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
                case 8:
                    HashSet<Transaction> transactions = transactionService.getAllTransactions();
                    transactions.forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Entre account identifier that you  close ");
                    String identifier = sc.nextLine();
                    accountService.closeAccount(identifier);
                case 10:
                    Session.endSession();
                    new AccountMenu().showMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(true);


    }
}
