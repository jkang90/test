package com.phil.server.server.service;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public Shipment getShipmentDetails(Long trackingnumber) {
        // TODO add exception handling for not-found shipments
        Shipment getShipment = shipmentRepository.findShipmentByTrackingnumber(trackingnumber);
        return getShipment;
    }

    @Override
    public Shipment saveShipment(Shipment shipment) {
        // TODO add exception handling for unable to save shipment
        return shipmentRepository.save(shipment);
    }
}
