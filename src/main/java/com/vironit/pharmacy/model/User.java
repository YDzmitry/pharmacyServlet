package com.vironit.pharmacy.model;


import com.vironit.pharmacy.dao.Identified;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable, Identified<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "typeaccount_id")
    private TypeAccount typeAccount;


    public User(String login, String password, TypeAccount typeAccount, Role role) {
        this.login = login;
        this.password = password;
        this.typeAccount = typeAccount;
        this.role = role;
    }



    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }

    public Integer getId() {
        return id;
    }

}
