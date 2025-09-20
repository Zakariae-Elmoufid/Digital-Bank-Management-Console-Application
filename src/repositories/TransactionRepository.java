package repositories;

import interfaces.TransactionInterface;
import model.Account;
import model.Transaction;
import services.TransactionService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;


public class TransactionRepository<accountId> implements TransactionInterface {

    private static  HashSet<Transaction> transactions = new HashSet<Transaction>();

    public Transaction deposit(BigDecimal amount, Account account) {
        account.diposit(amount);
        Transaction transaction= new Transaction("DEPOSIT",amount,account.getId());
        transactions.add(transaction);
        return transaction;
    }

    public Transaction withdraw(BigDecimal amount, Account account) {
        account.withdraw(amount);
        Transaction transaction= new Transaction("WITHDRAW",amount,account.getId());
        transactions.add(transaction);
        return transaction;
    }

    public Transaction transfer(Account fromAccount, Account toAccount, BigDecimal amount, String description) {
        fromAccount.withdraw(amount);
        toAccount.diposit(amount);
        Transaction transferIn = new Transaction("TRANSFERIN",amount,fromAccount.getId(),toAccount.getId(),description);
        transactions.add(transferIn);
        Transaction transferOut = new Transaction("TRANSFEROUT",amount,toAccount.getId(),fromAccount.getId(),description);
        transactions.add(transferOut);
        return transferIn;
    }

    public HashSet<Transaction> getAll() {
        return transactions;
    }









}
