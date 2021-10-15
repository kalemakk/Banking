package com.example.banking.Repository;

import com.example.banking.Models.Account;
import com.example.banking.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findTransactionsByAccount_Id(Long account_id);

}
