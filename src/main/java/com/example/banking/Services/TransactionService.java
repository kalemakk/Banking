package com.example.banking.Services;

import com.example.banking.Models.Account;
import com.example.banking.Models.Customer;
import com.example.banking.Models.Transaction;
import com.example.banking.Models.TransactionType;
import com.example.banking.Repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private TransactionRepository transactionRepository;

    public void recordTransaction(BigDecimal amount, TransactionType transactionType, Account account){
        Transaction transaction = new Transaction(amount, transactionType, UUID.randomUUID().toString(),account);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getCustomerTransactions(Account account){

        return transactionRepository.findTransactionsByAccount_Id(account.getId());
    }
}
