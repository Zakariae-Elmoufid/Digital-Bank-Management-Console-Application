package services;

import model.Account;
import repositories.AccountRepository;
import repositories.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;

public class TransactionService {

    private TransactionRepository transactionRepository ;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public List<Account> listAccount() {
        AccountRepository  accountRepository =  new AccountRepository();
        return accountRepository.getAll();
    }


    public boolean deposit(BigDecimal amount, Account account) {
        List<Account> accounts =  this.listAccount();
        account.diposit(amount);
        return true;
    }

    public boolean withdraw(BigDecimal amount,Account account) {
        if(amount.compareTo(account.getBalance()) < 0){
            account.withdraw(amount);
            return true;
        }else{
            return false;
        }
    }

    public boolean transfer(Account fromAccount, Account toAccount , BigDecimal amount){
        if(amount.compareTo(fromAccount.getBalance()) < 0 ){
            this.withdraw(amount,fromAccount);
            this.deposit(amount,toAccount);
            return true;
        }
        return false;
    }


}
