package com.example.resmed.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HourLabel {
    @Id
    @GeneratedValue
    private Long labelId;
    private String label;


//    @OneToMany(mappedBy = "hourLabel")
//    @JoinColumn(name = "hourLabel")
//    private Set<Rdv> rdvs;

    public HourLabel(Long labelId) {
        this.labelId = labelId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
