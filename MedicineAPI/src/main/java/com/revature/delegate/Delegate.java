package com.revature.delegate;

import com.revature.beans.Inventory;
import com.revature.beans.Medicine;
import com.revature.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Delegate {

    private MedicineService medicineService;
    @Autowired
    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    /******************************** Medicine *************************************/

    public ResponseEntity<Medicine> saveMedicine(Medicine medicine){
        return medicineService.saveMedicine(medicine);
    }

    public ResponseEntity<Medicine> findMedicineById(Integer id){
        return medicineService.findMedicineById(id);
    }

    public ResponseEntity<List<Medicine>> findAllMedicine(){
        return medicineService.findAllMedicine();
    }

    /******************************** Inventory *************************************/

    public ResponseEntity<Inventory> saveInventory(Inventory inventory){
        return medicineService.saveInventory(inventory);
    }

    public ResponseEntity<Inventory> findInventoryById(Integer id){
        return medicineService.findInventoryById(id);
    }

    public ResponseEntity<List<Inventory>> findAllInventory(){
        return medicineService.findAllInventory();
    }
}
