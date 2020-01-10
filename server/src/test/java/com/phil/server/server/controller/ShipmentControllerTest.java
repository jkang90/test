package com.phil.server.server.controller;

import com.phil.server.server.model.Shipment;
import com.phil.server.server.service.ShipmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class ShipmentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ShipmentController shipmentController;

    @Mock
    private ShipmentService shipmentService;

    private Shipment shipmentObj;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(shipmentController).build();
        shipmentObj = new Shipment();
        shipmentObj.setId(1L);
        shipmentObj.setTrackingnumber(100L);
        shipmentObj.setName("Phil");
    }

    @Test
    public void getShipmentDetails_SUCCESS() throws Exception {
        // this is used to call the rest endpoint
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/shipment/{trackingnumber}", 100L)
                .accept(MediaType.APPLICATION_JSON);

        Mockito.when(shipmentService.getShipmentDetails(anyLong())).thenReturn(shipmentObj);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

    }
        @Test
        public void addShipment() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/shipment/addshipment")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(createShipment(100L, "This is a test"));
            Mockito.when(shipmentService.saveShipment(any(Shipment.class))).thenReturn(shipmentObj);

            MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

            System.out.println(result.getResponse().getContentAsString());
        }

    //helper method to create string version of body
    private String createShipment(Long trackingNum, String name){
        return String.format(
                "{ \"trackingNum\": %d, \"name\": \"%s\"}",
                trackingNum, name
        );
    }
}
