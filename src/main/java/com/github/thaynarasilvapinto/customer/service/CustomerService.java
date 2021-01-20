package com.github.thaynarasilvapinto.customer.service;

import com.github.thaynarasilvapinto.customer.entitie.Customer;
import com.github.thaynarasilvapinto.customer.repositoy.CustomerRepository;
import com.github.thaynarasilvapinto.customer.request.CustomerRequest;
import com.github.thaynarasilvapinto.customer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse create(CustomerRequest customerRequest){

        if(customerRepository.findByCpf(customerRequest.getCpf()) != null){
            throw new RuntimeException("Customer já existe");
        }
        Customer customer = new Customer(customerRequest.getName(), customerRequest.getCpf(), LocalDateTime.now());

        customer = customerRepository.saveAndFlush(customer);

        return new CustomerResponse(customer.getId(), customer.getName(), customer.getCpf());
    }

    public CustomerResponse update(CustomerRequest customerRequest, Long id){

        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()){
            throw new RuntimeException("Customer não existe");
        }

        Customer customer = customerOptional.get();

        customer.setName(customerRequest.getName());
        customer = customerRepository.saveAndFlush(customer);

        return new CustomerResponse(customer.getId(), customer.getName(), customer.getCpf());
    }

    public CustomerResponse findByCustomer(Long id){

        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()){
            throw new RuntimeException("Customer não existe");
        }

        return new CustomerResponse(customerOptional.get().getId(), customerOptional.get().getName(), customerOptional.get().getCpf());
    }

    public void delete(Long id){

        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()){
            throw new RuntimeException("Customer não existe");
        }

        Customer customer = customerOptional.get();

        customerRepository.delete(customer);
    }

}
