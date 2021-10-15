package com.example.banking.Services;

import com.example.banking.Models.Account;
import com.example.banking.Models.Customer;
import com.example.banking.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor

public class CustomerService {

    private CustomerRepository customerRepository;

    private AccountService accountService;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
        accountService.createSavingsAccount(customer);
    }

    public BigDecimal withDrawCash(String accNumber, Long Id, BigDecimal cash){

        Customer customer = customerRepository.findCustomerById(Id);
        return accountService.deductCash(accNumber, cash, customer);
    }

    public BigDecimal topUpCash(String accNumber, Long Id, BigDecimal cash){

        Customer customer = customerRepository.findCustomerById(Id);
        return accountService.addCash(accNumber, cash, customer);
    }

    public BigDecimal getCurrentBalance(String accNumber){

        Account account = accountService.getAccountByAccNumber(accNumber);
        return account.getActualBalance();
    }



}
