package services;

import model.Account;
import repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
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

    public List<Account> listAccount() {
        return accountRepository.getAll();
    }

    public Account verifyRib(String rib){
        List<Account> accounts =  this.listAccount();
        Account  account = (Account) accounts.stream().filter(acc -> acc.getId().equals(rib)).findFirst().orElse(null);
        return account;
    }

    public String closeAccount(String  accountId){
        List<Account> accounts =  this.listAccount();
        Account account = accounts.stream()
                .filter(acc -> acc.getId().equals(accountId))
                .findFirst()
                .orElse(null);

        if (account == null) {
            return "Account not found";
        }

        // Check balance
        if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            return "Balance is more than 0, cannot close account";
        }

        // Close account
        accountRepository.colseAccount(account);
        return "Account closed successfully";
    }


}
