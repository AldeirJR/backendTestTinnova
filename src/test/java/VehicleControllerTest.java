package com.example.cadastro_veiculos;

import com.example.cadastro_veiculos.model.Vehicle;
import com.example.cadastro_veiculos.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class VehicleControllerTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @BeforeEach
    public void setup() {
        vehicleRepository.deleteAll();
    }

    @Test
    public void testCreateVehicle() {
        Vehicle vehicle = new Vehicle("Ford", "Fiesta", 2010, false);
        Vehicle saved = vehicleRepository.save(vehicle);

        Assertions.assertNotNull(saved.getId());
        Assertions.assertEquals("Ford", saved.getMarca());
    }

    @Test
    public void testCountNotSold() {
        Vehicle v1 = new Vehicle("VW", "Gol", 2005, false);
        Vehicle v2 = new Vehicle("Honda", "Civic", 2020, true);
        vehicleRepository.save(v1);
        vehicleRepository.save(v2);

        long notSoldCount = vehicleRepository.countByVendidoFalse();
        Assertions.assertEquals(1, notSoldCount);
    }
}
