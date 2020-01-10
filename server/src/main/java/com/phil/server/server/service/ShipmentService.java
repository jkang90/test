package com.phil.server.server.service;

import com.phil.server.server.model.Shipment;

public interface ShipmentService {

    public Shipment getShipmentDetails(Long trackingnumber);
    public Shipment saveShipment(Shipment shipment);
}
