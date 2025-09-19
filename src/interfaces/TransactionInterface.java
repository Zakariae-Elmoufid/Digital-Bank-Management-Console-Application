package interfaces;

import model.Account;
import model.Transaction;

import java.math.BigDecimal;
import java.util.HashSet;

public interface TransactionInterface {
    public Transaction deposit(BigDecimal amount , Account account);
    public Transaction withdraw(BigDecimal amount, Account account);
    public Transaction transfer(Account fromAccount, Account toAccount,BigDecimal amount,String description);
    public HashSet<Transaction> getAll();
}
