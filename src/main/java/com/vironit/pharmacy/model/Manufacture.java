package com.vironit.pharmacy.model;

import java.io.Serializable;

public class Manufacture extends BaseEntity implements Serializable{

    private Address address;
    private String description;

    public Manufacture(Address address, String description) {
        this.address = address;
        this.description = description;
    }

    public Manufacture() {
    }
}
