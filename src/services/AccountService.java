package services;

import model.Account;
import repositories.AccountRepository;

import java.util.UUID;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public boolean  createAccount(UUID userId) {
        Account account = accountRepository.create(userId);
        if(account != null){
            return true;
        }
        return false;
    }
}
