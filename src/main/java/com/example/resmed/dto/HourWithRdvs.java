package com.example.resmed.dto;

import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Rdv;

import java.util.List;

public class HourWithRdvs {
    private HourLabel hourLabel;
    private List<Rdv> rdvs;

    public HourLabel getHourLabel() {
        return hourLabel;
    }

    public void setHourLabel(HourLabel hourLabel) {
        this.hourLabel = hourLabel;
    }

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }

    public HourWithRdvs(HourLabel hourLabel, List<Rdv> rdvs) {
        this.hourLabel = hourLabel;
        this.rdvs = rdvs;
    }
}
