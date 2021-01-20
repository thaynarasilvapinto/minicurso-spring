package com.github.thaynarasilvapinto.customer.request;

public class CustomerRequest {

    private String name;
    private String cpf;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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
