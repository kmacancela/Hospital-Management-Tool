package com.revature.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Clinic;
import com.revature.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sibrian on 2/19/17.
 */
@Service
public class UserRecordsService {

    private EurekaClient discoveryClient;

    @Autowired
    public void setDiscoveryClient(EurekaClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    //*************************************User******************************************//

    public ResponseEntity<User> saveUser(User user) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("user");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo userInstanceInfo = list.get(0);

        String host = "http://" + userInstanceInfo.getHostName()+":"+ userInstanceInfo.getPort()+"/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> response = new HttpEntity<User>(user, headers);

        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("user/save").build().toString();
        ResponseEntity<User> userResponse = restTemplate.exchange(URI, HttpMethod.POST, response, User.class);
        return userResponse;
    }

    public ResponseEntity<List<User>> findAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("user");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo userInstanceInfo = list.get(0);
        String host = "http://"+userInstanceInfo.getHostName()+":"+userInstanceInfo.getPort()+"/";

        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("user/getAll").build().toString();
        ResponseEntity<User[]> response = null;
        List<User> users = new ArrayList<User>();

        try {
            response = restTemplate.getForEntity(URI, User[].class);
            users = Arrays.asList(response.getBody());
        } catch(RuntimeException e) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    public ResponseEntity<User> findUserById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("user");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo userInstanceInfo = list.get(0);
        String host = "http://"+userInstanceInfo.getHostName()+":"+userInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("user/search/id/").path(id.toString()).build().toString();

        User user = null;
        ResponseEntity<User> response = null;

        try {
            response = restTemplate.getForEntity(URI, User.class);
            user = response.getBody();
        } catch (RuntimeException rte) {
            response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    public ResponseEntity<User> findUserByLastName(String lName) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("user");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo userInstanceInfo = list.get(0);
        String host = "http://"+userInstanceInfo.getHostName()+":"+userInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("user/search/name/").path(lName.toString()).build().toString();

        User user = null;
        ResponseEntity<User> response = null;

        try {
            response = restTemplate.getForEntity(URI, User.class);
            user = response.getBody();
        } catch (RuntimeException rte) {
            response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

//****************************************************Clinic***********************************************//

    public ResponseEntity<Clinic> saveClinic(Clinic clinic) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("clinic");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo clinicInstanceInfo = list.get(0);

        String host = "http://" + clinicInstanceInfo.getHostName()+":"+ clinicInstanceInfo.getPort()+"/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Clinic> response = new HttpEntity<Clinic>(clinic, headers);

        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("clinic/save").build().toString();
        ResponseEntity<Clinic> clinicResponse = restTemplate.exchange(URI, HttpMethod.POST, response, Clinic.class);
        return clinicResponse;
    }

    public ResponseEntity<List<Clinic>> findAllClinics() {
        RestTemplate restTemplate = new RestTemplate();
        Application application = discoveryClient.getApplication("clinic");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo clinicInstanceInfo = list.get(0);
        String host = "http://"+clinicInstanceInfo.getHostName()+":"+clinicInstanceInfo.getPort()+"/";

        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("clinic/getAll").build().toString();
        ResponseEntity<Clinic[]> response = null;
        List<Clinic> clinics = new ArrayList<Clinic>();

        try {
            response = restTemplate.getForEntity(URI, Clinic[].class);
            clinics = Arrays.asList(response.getBody());
        } catch(RuntimeException e) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Clinic>>(clinics,HttpStatus.OK);
    }

    public ResponseEntity<Clinic> findClinicByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("clinic");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo clinicInstanceInfo = list.get(0);
        String host = "http://"+clinicInstanceInfo.getHostName()+":"+clinicInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("clinic/search/name").path(name.toString()).build().toString();

        Clinic clinic = null;
        ResponseEntity<Clinic> response = null;

        try {
            response = restTemplate.getForEntity(URI, Clinic.class);
            clinic = response.getBody();
        } catch (RuntimeException rte) {
            response = new ResponseEntity<Clinic>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Clinic>(clinic,HttpStatus.OK);

    }

    public ResponseEntity<Clinic> findClinicById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        Application application = discoveryClient.getApplication("clinic");
        List<InstanceInfo> list = application.getInstances();

        InstanceInfo clinicInstanceInfo = list.get(0);
        String host = "http://"+clinicInstanceInfo.getHostName()+":"+clinicInstanceInfo.getPort()+"/";
        final String URI = UriComponentsBuilder.fromHttpUrl(host).path("clinic/search/id").path(id.toString()).build().toString();

        Clinic clinic = null;
        ResponseEntity<Clinic> response = null;

        try {
            response = restTemplate.getForEntity(URI, Clinic.class);
            clinic = response.getBody();
        } catch (RuntimeException rte) {
            response = new ResponseEntity<Clinic>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Clinic>(clinic,HttpStatus.OK);
    }
}























