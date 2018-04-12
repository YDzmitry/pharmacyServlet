package com.vironit.pharmacy.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity{

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "info")
    private String info;

    @OneToOne /// глянуть что тут писать
    @PrimaryKeyJoinColumn
    private User user;

    public Review(int mark, String info, User user) {
        this.mark = mark;
        this.info = info;
        this.user = user;
    }


    public Review() {
    }
}
