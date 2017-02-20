package com.revature.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Inventory;
import com.revature.beans.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MedicineService {

    private EurekaClient discoveryClient;

    @Autowired
    public void setDiscoveryClient(EurekaClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    //*********************************Medicine Code*******************************************//
    public ResponseEntity<Medicine> saveMedicine(Medicine medicine){
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("medicine");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo medicineInstanceInfo = list.get(0);

        String url = "http://"+medicineInstanceInfo.getHostName()+":"+medicineInstanceInfo.getPort()+"/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Medicine> response = new HttpEntity<Medicine>(medicine,headers);
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("medicine/save").build().toString();
        ResponseEntity<Medicine> medicineResponse = restTemplate.exchange(URI, HttpMethod.POST, response, Medicine.class);
        return medicineResponse;
    }
    public ResponseEntity<List<Medicine>> findAllMedicine(){
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("medicine");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo medicineInstanceInfo = list.get(0);
        String url = "http://"+medicineInstanceInfo.getHostName()+":"+medicineInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("medicine/all").build().toString();
        ResponseEntity<Medicine[]> response = null;
        List<Medicine> medicine = new ArrayList<Medicine>();

        try{
            response = restTemplate.getForEntity(URI, Medicine[].class);
            medicine = Arrays.asList(response.getBody());
        }catch(RuntimeException e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Medicine>>(medicine,HttpStatus.OK);
    }
    public ResponseEntity<Medicine> findMedicineById(Integer id){
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("medicine");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo medicineInstanceInfo = list.get(0);

        String url = "http://"+ medicineInstanceInfo.getHostName()+":"+medicineInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("medicine/id/").path(id.toString()).build().toString();

        Medicine medicine = null;
        ResponseEntity<Medicine> response = null;

        try{
            response= restTemplate.getForEntity(URI, Medicine.class);
            medicine = response.getBody();
        }
        catch(RuntimeException e){
            response = new ResponseEntity<Medicine>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Medicine>(medicine,HttpStatus.OK);
    }

    //************************************Inventory Code ***************************************************//
    public ResponseEntity<Inventory> saveInventory(Inventory inventory){
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("inventory");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo inventoryInstanceInfo = list.get(0);

        String url = "http://"+inventoryInstanceInfo.getHostName()+":"+inventoryInstanceInfo.getPort()+"/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Inventory> response = new HttpEntity<Inventory>(inventory,headers);
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("inventory/save").build().toString();
        ResponseEntity<Inventory> inventoryResponse = restTemplate.exchange(URI, HttpMethod.POST, response, Inventory.class);
        return inventoryResponse;
    }

    public ResponseEntity<List<Inventory>> findAllInventory(){
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("inventory");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo inventoryInstanceInfo = list.get(0);
        String url = "http://"+inventoryInstanceInfo.getHostName()+":"+inventoryInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("inventory/all").build().toString();
        ResponseEntity<Inventory[]> response = null;
        List<Inventory> inventory = new ArrayList<Inventory>();

        try{
            response = restTemplate.getForEntity(URI, Inventory[].class);
            inventory = Arrays.asList(response.getBody());
        }catch(RuntimeException e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Inventory>>(inventory,HttpStatus.OK);
    }

    public ResponseEntity<Inventory> findInventoryById(Integer id){
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("inventory");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo inventoryInstanceInfo = list.get(0);

        String url = "http://"+ inventoryInstanceInfo.getHostName()+":"+inventoryInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(url).path("inventory/id/").path(id.toString()).build().toString();

        Inventory inventory = null;
        ResponseEntity<Inventory> response = null;

        try{
            response= restTemplate.getForEntity(URI, Inventory.class);
            inventory = response.getBody();
        }
        catch(RuntimeException e){
            response = new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Inventory>(inventory,HttpStatus.OK);
    }
}
