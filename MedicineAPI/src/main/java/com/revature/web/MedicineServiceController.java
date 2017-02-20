package com.revature.web;

import com.revature.beans.Inventory;
import com.revature.beans.Medicine;
import com.revature.delegate.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineServiceController {

    private Delegate delegate;
    @Autowired
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /******************************** Medicine *************************************/

    @RequestMapping(value="/medicine/save",
                    method=RequestMethod.POST,
                    produces=MediaType.APPLICATION_JSON_VALUE,
                    consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine){
        return delegate.saveMedicine(medicine);
    }

    @RequestMapping(value="/medicine/id/{medicineId}",
                    method= RequestMethod.GET,
                    produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicine> findByMedicineId(@PathVariable Integer medicineId){
        return delegate.findMedicineById(medicineId);
    }

    @RequestMapping(value="/medicine/all",
                    method=RequestMethod.GET,
                    produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Medicine>> findAllMedicine(){
        return delegate.findAllMedicine();
    }

    /******************************** Inventory *************************************/

    @RequestMapping(value="/inventory/save",
                    method=RequestMethod.POST,
                    produces=MediaType.APPLICATION_JSON_VALUE,
                    consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
        return delegate.saveInventory(inventory);
    }

    @RequestMapping(value="/inventory/id/{inventoryId}",
                    method= RequestMethod.GET,
                    produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> findByInventoryId(@PathVariable Integer inventoryId){
        return delegate.findInventoryById(inventoryId);
    }

    @RequestMapping(value="/inventory/all",
                    method=RequestMethod.GET,
                    produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Inventory>> findAllInventory(){
        return delegate.findAllInventory();
    }
}
