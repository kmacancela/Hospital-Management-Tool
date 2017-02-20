package com.revature.beans;

import org.springframework.data.annotation.Id;

public class Medicine {

    @Id
    private int medicineId;
    private String name;
    private String type;
    private String price;

    public Medicine(){}

    public Medicine(int medicineId, String name, String type, String price) {
        this.medicineId = medicineId;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
