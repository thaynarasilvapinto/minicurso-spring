package com.github.thaynarasilvapinto.customer.controller;

import com.github.thaynarasilvapinto.customer.request.CustomerRequest;
import com.github.thaynarasilvapinto.customer.response.CustomerResponse;
import com.github.thaynarasilvapinto.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.create(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") Long id, @RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.update(customerRequest, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findByCustomer(@PathVariable("id") Long id){
        CustomerResponse response = customerService.findByCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        customerService.delete(id);
    }
}
