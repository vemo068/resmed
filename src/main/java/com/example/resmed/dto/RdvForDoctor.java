package com.example.resmed.dto;

public class RdvForDoctor {
    private Long rdvId;
    private String patientName;
    private String patientPhone;

    public RdvForDoctor(Long rdvId, String patientName, String patientPhone) {
        this.rdvId = rdvId;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
    }

    public Long getRdvId() {
        return rdvId;
    }

    public void setRdvId(Long rdvId) {
        this.rdvId = rdvId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }
}
