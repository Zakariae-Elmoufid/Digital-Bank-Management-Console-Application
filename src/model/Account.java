package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class Account {
    private String id;
    private BigDecimal balance;
    private LocalDateTime createAt;
    private boolean active;
    private UUID userId;

    Random random = new Random();

    public Account( UUID userId) {
        this.id = "BK-"+ random.nextInt(1000) +"-"+random.nextInt(1000);
        this.balance = new BigDecimal("0.00");
        this.createAt = LocalDateTime.now() ;
        this.userId = userId;
        this.active = true;
    }


    public String getId(){
        return this.id;
    }

    public  void  diposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }


    @Override
    public String toString() {
        return "Account{" +
                "Rib ='" + id + '\'' +
                ", balance=" + balance +
                ", createAt=" + createAt +
                ", active=" + active +
                ", userId=" + userId +
                '}';
    }
}