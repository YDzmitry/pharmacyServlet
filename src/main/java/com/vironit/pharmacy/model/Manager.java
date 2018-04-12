package com.vironit.pharmacy.model;


public class Manager extends User {

    private String passport;
    private Double balance;
    private Integer level;

    public Manager(String login, String password, Role role, TypeAccount typeAccount, String passport, double balance, int level) {
        super(login, password, typeAccount,role);
        this.passport = passport;
        this.balance = balance;
        this.level = level;
    }

    public Manager() {
    }

    @Override
    public String toString() {
        return super.toString() +
                ", passport='" + passport + '\'' +
                ", balance='" + balance + '\'' +
                ", level=" + level +
                " }";
    }

    public String getPassport() {
        return passport;
    }

    public double getBalance() {
        return balance;
    }

    public int getLevel() {
        return level;
    }
}
