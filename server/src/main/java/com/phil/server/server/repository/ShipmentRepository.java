package com.phil.server.server.repository;

import com.phil.server.server.model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    public Shipment findShipmentByTrackingnumber(Long trackingNumber);
}
