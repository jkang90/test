package com.phil.client.client.service;

import com.phil.client.client.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Shipment getShipment(Long trackingnumber) {
        String url = String.format("http://localhost:9001/shipment/%d", trackingnumber);
        //get request
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Shipment> entity = new HttpEntity<>(header);
        Shipment response = restTemplate.getForObject(url, Shipment.class);
        return response;
    }

    @Override
    public Shipment addShipment(Shipment shipment) {
        String url = "http://localhost:9001/shipment/addshipment";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Shipment> entity = new HttpEntity<>(shipment, header);
        Shipment response = restTemplate.postForObject(url, entity, Shipment.class);
        return response;
    }
}
