package com.example.cadastro_veiculos.service;

import com.example.cadastro_veiculos.model.Vehicle;
import com.example.cadastro_veiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle updatedVehicle) {
        Vehicle existing = findById(id);
        existing.setMarca(updatedVehicle.getMarca());
        existing.setModelo(updatedVehicle.getModelo());
        existing.setAno(updatedVehicle.getAno());
        existing.setVendido(updatedVehicle.isVendido());
        // updatedAt é atualizado automaticamente via @PreUpdate
        return vehicleRepository.save(existing);
    }

    public void delete(Long id) {
        Vehicle existing = findById(id);
        vehicleRepository.delete(existing);
    }

    public long countNotSold() {
        return vehicleRepository.countByVendidoFalse();
    }

    public List<Object[]> distributionByDecade() {
        return vehicleRepository.findDistributionByDecade();
    }

    public List<Object[]> distributionByMarca() {
        return vehicleRepository.findDistributionByMarca();
    }

    public List<Vehicle> lastWeekVehicles() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
        return vehicleRepository.findByCreatedAtAfter(oneWeekAgo);
    }

    public List<Vehicle> searchByMarca(String marca) {
        return vehicleRepository.findByMarcaIgnoreCase(marca);
    }

    public List<Vehicle> searchByDecada(int decada) {
        return vehicleRepository.findByDecada(decada);
    }
}
