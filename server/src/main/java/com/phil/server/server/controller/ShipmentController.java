package com.phil.server.server.controller;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @GetMapping("/{trackingnumber}")
    public Shipment getShipmentDetails(@PathVariable Long trackingnumber){
        return shipmentService.getShipmentDetails(trackingnumber);
    }

    @PostMapping("/addshipment")
    public Shipment addShipment(@RequestBody Shipment shipment){
        return shipmentService.saveShipment(shipment);
    }
}
