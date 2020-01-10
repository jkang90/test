package com.phil.server.server.integration;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.repository.ShipmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class IntegrationTest {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Test
    public void saveAndRetrieve(){
        // save the shipment details
        Shipment testShipment = new Shipment();
        testShipment.setId(1L);
        testShipment.setName("This is a test 1");
        testShipment.setTrackingnumber(100L);
        shipmentRepository.save(testShipment);

        // do a get request
        Shipment testObj = shipmentRepository.findShipmentByTrackingnumber(testShipment.getTrackingnumber());

        Assert.assertEquals(testObj.getTrackingnumber(), testShipment.getTrackingnumber());
    }
}
