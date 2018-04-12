package com.vironit.pharmacy.model;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Medicine extends BaseEntity implements Serializable{

    private String description;
    private Boolean receiptIsNeed;
    private Integer price;
    private Manufacture manufactor;

    @ManyToMany
    @JoinTable(name = "medicine_effecttouse",
            joinColumns = @JoinColumn(name = "medicine_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id",referencedColumnName = "id")
    )
    private List<EffectToUse> effectToUseList;

    @ManyToMany
    @JoinTable(name = "medicine_indicatorstouse",
            joinColumns = @JoinColumn(name = "medicine_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "indicator_id",referencedColumnName = "id")
    )
    private List<IndicatorsToUse> indicatorsToUseList;


    public Medicine(String description, boolean receiptIsNeed, int price, ArrayList<EffectToUse> effectToUseList, ArrayList<IndicatorsToUse> indicatorsToUseList) {
        this.description = description;
        this.receiptIsNeed = receiptIsNeed;
        this.price = price;
        this.effectToUseList = effectToUseList;
        this.indicatorsToUseList = indicatorsToUseList;
    }

    public Medicine() {
    }
}
