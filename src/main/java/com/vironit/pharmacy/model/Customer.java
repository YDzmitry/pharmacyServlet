package com.vironit.pharmacy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user")
public class Customer extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "phone")
    private String phone;


    private List<Address> addressDeliveryList;

    public Customer(String login, String password, Role role, TypeAccount typeAccount, String name, String surname, double balance, String phone) {
        super(login, password,typeAccount,role);
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAddressDeliveryList() {
        return addressDeliveryList;
    }

    public void setAddressDeliveryList(List<Address> addressDeliveryList) {
        this.addressDeliveryList = addressDeliveryList;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", phone='" + phone + '\'' +
                " }";
    }
}
