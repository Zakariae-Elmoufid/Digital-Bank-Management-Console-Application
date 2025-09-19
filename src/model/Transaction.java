package model;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    private String  accountId;
    private String  counterpartyAccountId;
    private String  description;
    private String  type;

    public Transaction(String type , BigDecimal amount, String accountId,String counterpartyAccountId, String description ) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
        this.counterpartyAccountId = counterpartyAccountId;
        this.description = description ;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction(String type , BigDecimal amount, String accountId) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
        this.timestamp = LocalDateTime.now();
    }




    @Override
    public String toString() {
        return "========= Historique des transactions ========\n"
                + "Type: " + type + "\n"
                + "Amount: " + amount + "\n"
                + "Account Id: " + accountId + "\n"
                + "Counterparty Account Id: " + counterpartyAccountId + "\n"
                + "Description: " + description + "\n"
                + "Timestamp: " + timestamp + "\n";
    }
}
