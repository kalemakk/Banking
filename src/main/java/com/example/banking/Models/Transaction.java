package com.example.banking.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String referenceNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Transaction(BigDecimal amount, TransactionType transactionType, String referenceNumber, Account account) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.referenceNumber = referenceNumber;
        this.account = account;
    }

    public Transaction(){

    }
}
