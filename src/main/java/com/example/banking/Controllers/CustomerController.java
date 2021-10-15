package com.example.banking.Controllers;

import com.example.banking.Models.Customer;
import com.example.banking.Repository.CustomerRepository;
import com.example.banking.Services.AccountService;
import com.example.banking.Services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @PostMapping("/with-draw")
    public String withDrawCash(
            @RequestParam(value = "customerId") Long customerId,
            @RequestParam(value = "accNumber") String accNumber,
            @RequestParam(value = "amount") BigDecimal amount
    ) {
        BigDecimal balance = customerService.withDrawCash(accNumber, customerId, amount);

        if (balance == null){

            return "your balance is very low, please deposit more cash";
        }
        return "remaining balance is " + balance;
    }


    @PostMapping("/deposit")
    public String depositCash(
            @RequestParam(value = "customerId") Long customerId,
            @RequestParam(value = "accNumber") String accNumber,
            @RequestParam(value = "amount") BigDecimal amount
    ) {
        BigDecimal balance = customerService.topUpCash(accNumber, customerId, amount);

        if (balance == null) {
            return "Customer doesn't own the account";
        }
        return "Current account balance is " + balance;
    }

    @GetMapping("/balance")
    public String getCurrentBalance(
            @RequestParam(value = "accNumber") String accNumber
            ){
        BigDecimal balance = customerService.getCurrentBalance(accNumber);

        return "Your current balance is "+balance;
    }


}
