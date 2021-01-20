package com.github.thaynarasilvapinto.customer.entitie;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "create_at")
    private LocalDateTime createAt;


    public Customer() {
    }

    public Customer(String name, String cpf, LocalDateTime createAt) {
        this.name = name;
        this.cpf = cpf;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
