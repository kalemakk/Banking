package com.example.banking.Repository;

import com.example.banking.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account getAccountByAccNumber(String accNumber);
}