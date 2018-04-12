package com.vironit.pharmacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity implements Serializable {

    private List<Medicine> medicineList;
    private Integer amount;
    private OrderType orderType;
    private Address address;

    public Order(ArrayList<Medicine> medicineList, int amount, OrderType orderType, Address address) {
        this.medicineList = medicineList;
        this.amount = amount;
        this.orderType = orderType;
        this.address = address;
    }

    public Order() {
    }
}
