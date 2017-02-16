package com.revature.beans;

import org.springframework.data.annotation.Id;

/**
 * Created by kawee on 2/16/2017.
 */
public class Inventory {

    @Id
    private int inventoryId;
    private int medicineId;
    private int clinicId;
    private int stock;
    private String lastRestockDate;

    public Inventory(){}

    public Inventory(int inventoryId, int medicineId, int clinicId, int stock, String lastRestockDate) {
        this.inventoryId = inventoryId;
        this.medicineId = medicineId;
        this.clinicId = clinicId;
        this.stock = stock;
        this.lastRestockDate = lastRestockDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(String lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", medicineId=" + medicineId +
                ", clinicId=" + clinicId +
                ", stock=" + stock +
                ", lastRestockDate='" + lastRestockDate + '\'' +
                '}';
    }
}
