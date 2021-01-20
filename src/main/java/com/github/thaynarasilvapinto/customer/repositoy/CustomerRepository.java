package com.github.thaynarasilvapinto.customer.repositoy;

import com.github.thaynarasilvapinto.customer.entitie.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCpf(String cpf);
}
