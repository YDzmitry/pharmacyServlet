package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "effecttouse")
public class EffectToUse extends BaseEntity implements Serializable {

    @Column(name = "effect")
    private String effect;

    /*@ManyToMany(mappedBy = "effectToUseList")
    private List<Medicine> medicineList;*/

    public EffectToUse(String effect) {
        this.effect = effect;
    }

    public EffectToUse() {
    }
}
