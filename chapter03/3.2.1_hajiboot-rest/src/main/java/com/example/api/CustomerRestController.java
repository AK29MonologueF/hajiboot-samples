package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @GetMapping("test")
    Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        return customers;
    }
    @GetMapping(path = "{id}")
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }
    
    // 新規はPost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer createCustomer(Customer customer){
        Customer created = customerService.create(customer);
        return created;
    }
    
    // 更新はPut
    // @Requestbody でとして受け取る
    @PutMapping(path = "{id}")
    Customer putCustomer(@RequestBody Customer customer, @PathVariable Integer id){
    	customer.setId(id);
        Customer updated = customerService.update(customer);
    	return updated;
    }
    
    @DeleteMapping(path = "{id}" )
    void deleteCustomer(@PathVariable Integer id){
    	 customerService.delete(id);
    }
    
    


    
}
