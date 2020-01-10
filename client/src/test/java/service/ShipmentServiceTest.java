package service;

import com.phil.client.client.model.Shipment;
import com.phil.client.client.service.ShipmentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.*;
import org.springframework.web.client.RestTemplate;


@RunWith(MockitoJUnitRunner.class)
public class ShipmentServiceTest {

    @InjectMocks
    ShipmentServiceImpl shipmentService;

    @Mock
    RestTemplate restTemplate;

    private Shipment dummyShipment;
    @Before
    public void init(){
        dummyShipment = new Shipment();
        dummyShipment.setId(1L);
        dummyShipment.setName("Phil");
        dummyShipment.setTrackingnumber(101L);
    }
    @Test
    public void getShipment(){
        Mockito.when(restTemplate.getForObject(anyString(), any())).thenReturn(dummyShipment);
        Shipment returnedObj = shipmentService.getShipment(101L);
        Assert.assertEquals(returnedObj.getTrackingnumber(), dummyShipment.getTrackingnumber());
    }

    @Test
    public void addShipment(){
        Mockito.when(restTemplate.postForObject(anyString(), any(), any())).thenReturn(dummyShipment);
        Shipment returnedObj = shipmentService.addShipment(dummyShipment);
        Assert.assertEquals(returnedObj.getTrackingnumber(), dummyShipment.getTrackingnumber());
    }


}
