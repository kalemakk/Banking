package com.example.banking.Services;
import java.util.UUID;

import com.example.banking.Models.*;
import com.example.banking.Repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private TransactionService transactionService;

//    public void getAccountBalance(){
//
//    }

    public void createSavingsAccount(Customer customer){

        Account account = new Account(UUID.randomUUID().toString(), AccountType.SAVINGS, AccountStatus.APPROVED,BigDecimal.ZERO,customer);
        accountRepository.save(account);
    }

    public BigDecimal deductCash(String accNumber, BigDecimal withDrawAmount, Customer customer){

         Account account = accountRepository.getAccountByAccNumber(accNumber);

        if (account.getCustomer().getId().equals(customer.getId())){

            transactionService.recordTransaction(withDrawAmount, TransactionType.WITHDRAW,account);

            BigDecimal currentAmount = account.getActualBalance().subtract(withDrawAmount);

            if (BigDecimal.ZERO.compareTo(currentAmount) > 0){
                return null;
            }

            account.setActualBalance(currentAmount);

            accountRepository.save(account);

            return account.getActualBalance();

        }else {
             return null;
         }

    }

    public BigDecimal addCash(String accNumber, BigDecimal addedAmount, Customer customer){

        Account account = accountRepository.getAccountByAccNumber(accNumber);

        if (account.getCustomer().getId().equals(customer.getId())){

            transactionService.recordTransaction(addedAmount, TransactionType.DEPOSIT,account);

            BigDecimal currentAmount = account.getActualBalance().add(addedAmount);

            account.setActualBalance(currentAmount);

            accountRepository.save(account);

            return account.getActualBalance();

        }else {
            return null;
        }

    }

    public Account getAccountByAccNumber(String accNumber){
        return accountRepository.getAccountByAccNumber(accNumber);
    }
}
