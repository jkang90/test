package com.phil.client.client.controller;

import com.phil.client.client.model.Shipment;
import com.phil.client.client.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientfe")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @GetMapping("/shipment/{trackingnumber}")
    public Shipment getShipmentDetails(@PathVariable Long trackingnumber){
        return shipmentService.getShipment(trackingnumber);
    }

    @PostMapping("/addshipment")
    public Shipment addShipment(@RequestBody Shipment shipment){
        return shipmentService.addShipment(shipment);
    }
}
