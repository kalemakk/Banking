package com.example.banking.Controllers;

import com.example.banking.Models.Account;
import com.example.banking.Models.Transaction;
import com.example.banking.Services.AccountService;
import com.example.banking.Services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TransactionController {

    private TransactionService transactionService;
    private AccountService accountService;

    @GetMapping("/transactions")
    public List<Transaction> getCustomerTransactions(
            @RequestParam(value = "accNumber") String accNumber) {

        Account account = accountService.getAccountByAccNumber(accNumber);

        return transactionService.getCustomerTransactions(account);
    }

}
