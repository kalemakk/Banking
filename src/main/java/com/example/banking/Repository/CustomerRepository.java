package com.example.banking.Repository;

import com.example.banking.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerById(Long id);


}
