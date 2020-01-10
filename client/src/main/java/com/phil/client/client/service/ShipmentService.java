package com.phil.client.client.service;

import com.phil.client.client.model.Shipment;

public interface ShipmentService {

    public Shipment getShipment(Long trackingnumber);
    public Shipment addShipment(Shipment shipment);
}
