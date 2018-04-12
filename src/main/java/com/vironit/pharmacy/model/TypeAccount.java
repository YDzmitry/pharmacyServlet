package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "typeaccount")
public class TypeAccount implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "type")
    private String type;


    public TypeAccount(Integer id,String type) {
        this.id = id;
        this.type = type;
    }

    public TypeAccount() {
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }


}
