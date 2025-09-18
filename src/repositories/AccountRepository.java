package repositories;

import interfaces.AccountInterface;
import model.Account;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


public class AccountRepository implements AccountInterface {

    private static List<Account>  accounts = new ArrayList<>();


    public Account create(UUID userId){
        Account account = new  Account(userId);
        accounts.add(account);
        return account;
    }

}
