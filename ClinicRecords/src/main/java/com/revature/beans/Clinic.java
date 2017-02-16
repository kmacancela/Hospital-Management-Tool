package com.revature.beans;

import org.springframework.data.annotation.Id;

/**
 * Created by Sibrian on 2/16/17.
 */
public class Clinic {

    @Id
    private int clinicId;

    private String clinicName;
    private String clinicCity;
    private String clinicState;
    private String clinicAddress;
    private int clinicZip;

    public Clinic() {
        super();
    }

    public Clinic(int clinicId, String clinicName, String clinicCity, String clinicState, String clinicAddress, int clinicZip) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.clinicCity = clinicCity;
        this.clinicState = clinicState;
        this.clinicAddress = clinicAddress;
        this.clinicZip = clinicZip;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicCity() {
        return clinicCity;
    }

    public void setClinicCity(String clinicCity) {
        this.clinicCity = clinicCity;
    }

    public String getClinicState() {
        return clinicState;
    }

    public void setClinicState(String clinicState) {
        this.clinicState = clinicState;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public int getClinicZip() {
        return clinicZip;
    }

    public void setClinicZip(int clinicZip) {
        this.clinicZip = clinicZip;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicId=" + clinicId +
                ", clinicName='" + clinicName + '\'' +
                ", clinicCity='" + clinicCity + '\'' +
                ", clinicState='" + clinicState + '\'' +
                ", clinicAddress='" + clinicAddress + '\'' +
                ", clinicZip='" + clinicZip + '\'' +
                '}';
    }
}
