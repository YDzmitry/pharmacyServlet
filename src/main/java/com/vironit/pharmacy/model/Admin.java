package com.vironit.pharmacy.model;

public class Admin extends User{

    public Admin(String login, String password, Role role, TypeAccount typeAccount) {
        super(login, password, typeAccount,role);
    }

    public Admin(){}

    @Override
    public String toString() {
        return super.toString() +" }";
    }
}
