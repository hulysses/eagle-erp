package com.hulysses.eagleerp.supplier;

public class Supplier {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String cnpj;

    public Supplier(String name, String email, String phone, String address, String cnpj) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCnpj() {
        return cnpj;
    }
}
