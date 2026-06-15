package com.hulysses.eagleerp.models;

public class Supplier extends Person {
    private String cnpj;

    public Supplier(String name, String phone, String cnpj) {
        super(name, phone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
