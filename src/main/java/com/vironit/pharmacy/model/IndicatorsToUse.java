package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "indicatorstouse")
public class IndicatorsToUse extends BaseEntity implements Serializable {

    @Column(name = "indicator")
    private String indicator;


    public IndicatorsToUse(String indicator) {
        this.indicator = indicator;
    }

    public IndicatorsToUse() {
    }
}
