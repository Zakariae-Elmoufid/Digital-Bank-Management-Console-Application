package services;

import model.Account;
import model.Transaction;
import repositories.AccountRepository;
import repositories.TransactionRepository;

import java.math.BigDecimal;
import java.util.HashSet;
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
        Transaction transaction =  transactionRepository.deposit(amount, account);
        if(transaction != null) {
            return true;
        }
        return false;

    }

    public boolean withdraw(BigDecimal amount,Account account) {
        if(amount.compareTo(account.getBalance()) < 0){
            Transaction transaction = transactionRepository.withdraw(amount,account);
            if(transaction != null) {
                return true;
            }
        }
            return false;
    }

    public boolean transfer(Account fromAccount, Account toAccount , BigDecimal amount ,String description){
        if(amount.compareTo(fromAccount.getBalance()) < 0 ){
              Transaction transaction = transactionRepository.transfer(fromAccount,toAccount,amount,description);
            return true;
        }
        return false;
    }

    public HashSet<Transaction> getAllTransactions()
    {
       return  transactionRepository.getAll();
    }

}
