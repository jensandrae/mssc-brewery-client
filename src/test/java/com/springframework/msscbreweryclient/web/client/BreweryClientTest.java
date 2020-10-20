package com.springframework.msscbreweryclient.web.client;

import com.springframework.msscbreweryclient.web.model.BeerDto;
import com.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        BeerDto dto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Update Beer")
                .beerStyle("Custom Style")
                .build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test   // GET
    void testGetCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test   // POST
    void testCreateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        URI uri = client.saveCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test   // PUT
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test   // DELETE
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}