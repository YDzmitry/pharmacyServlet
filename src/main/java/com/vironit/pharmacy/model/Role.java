package com.vironit.pharmacy.model;

import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userrole")
    private String role;

    public Role(Integer id,String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    public String getRole() {
        return role;
    }


}
