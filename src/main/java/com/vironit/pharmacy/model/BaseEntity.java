package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;

public class BaseEntity implements Serializable{

    @Id
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }



}
