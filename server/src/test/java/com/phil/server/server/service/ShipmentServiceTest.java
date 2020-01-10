package com.phil.server.server.service;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.repository.ShipmentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
public class ShipmentServiceTest {

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @Mock
    private ShipmentRepository shipmentRepository;

    private Shipment shipmentObj;
    @Before
    public void init(){
        shipmentObj = new Shipment(1L, 100L, "Phil");

    }

    @Test
    public void getShipment_SUCCESS(){
        Mockito.when(shipmentRepository.findShipmentByTrackingnumber(anyLong())).thenReturn(shipmentObj);
        Shipment testShipment =shipmentService.getShipmentDetails(100L);
        Assert.assertEquals(testShipment.getTrackingnumber(), shipmentObj.getTrackingnumber());
    }

    @Test
    public void addShipment_SUCCESS(){
        Mockito.when(shipmentRepository.save(any(Shipment.class))).thenReturn(shipmentObj);
        Shipment testShipment = shipmentService.saveShipment(shipmentObj);
        Assert.assertEquals(testShipment.getTrackingnumber(), shipmentObj.getTrackingnumber());
    }

}
