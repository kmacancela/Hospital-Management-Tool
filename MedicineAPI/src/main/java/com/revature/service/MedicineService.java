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
    public Inventory saveInventory(Inventory inventoryItem){
        return null;
    }

    public List<Inventory> findAllInventory(){
        return null;
    }

    public Inventory findInventoryById(Integer id){
        return null;
    }
}
