package com.phil.server.server;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.repository.ShipmentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ServerApplication.class)
@ActiveProfiles("test")
class ServerApplicationTests {
	@Autowired
	ShipmentRepository shipmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void AddAndRetrieveShipmentDetails(){
		Shipment testShipment = new Shipment();
		testShipment.setId(1L);
		testShipment.setName("This is a test 1");
		testShipment.setTrackingnumber(100L);
		shipmentRepository.save(testShipment);
		Shipment newData = shipmentRepository.findShipmentByTrackingnumber(100L);
		Assert.assertEquals(testShipment.getTrackingnumber(), newData.getTrackingnumber());
	}

	@Test
	public void saveShipment(){
		Shipment testShipment = new Shipment();
		testShipment.setId(2L);
		testShipment.setName("This is a test 1");
		testShipment.setTrackingnumber(101L);
		Shipment savedShipment = shipmentRepository.save(testShipment);
		Assert.assertEquals(savedShipment.getTrackingnumber(), testShipment.getTrackingnumber());

	}

}
