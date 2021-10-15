package com.example.banking.Models;
import java.util.UUID;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data

@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private BigDecimal actualBalance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    public static String generateAccNumber(){
//        String num = UUID.randomUUID().toString();
//        return num;
//    }

    public Account(){

    }

    public Account(String accNumber, AccountType accountType, AccountStatus accountStatus, BigDecimal actualBalance, Customer customer) {
        this.accNumber = accNumber;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.actualBalance = actualBalance;
        this.customer = customer;
    }
}
