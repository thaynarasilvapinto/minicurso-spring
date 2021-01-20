package com.github.thaynarasilvapinto.customer.response;

import com.sun.istack.NotNull;

public class CustomerResponse {

    private Long id;
    @NotNull
    private String name;
    private String cpf;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
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
}
