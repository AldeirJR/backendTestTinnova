package com.example.cadastro_veiculos.controller;

import com.example.cadastro_veiculos.model.Vehicle;
import com.example.cadastro_veiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // 1) Listar todos os veículos
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    // 2) Obter veículo por ID
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.findById(id);
    }

    // 3) Criar um novo veículo
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    // 4) Atualizar veículo existente
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.update(id, vehicle);
    }

    // 5) Excluir veículo
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
    }

    // 6) Quantos veículos não vendidos
    @GetMapping("/count-not-sold")
    public Map<String, Long> countNotSold() {
        long count = vehicleService.countNotSold();
        Map<String, Long> response = new HashMap<>();
        response.put("notSold", count);
        return response;
    }

    // 7) Distribuição de veículos por década
    @GetMapping("/distribution-by-decade")
    public List<Map<String, Object>> distributionByDecade() {
        return vehicleService.distributionByDecade().stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("decada", obj[0]);
            map.put("quantidade", obj[1]);
            return map;
        }).toList();
    }

    // 8) Distribuição de veículos por fabricante (marca)
    @GetMapping("/distribution-by-marca")
    public List<Map<String, Object>> distributionByMarca() {
        return vehicleService.distributionByMarca().stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("marca", obj[0]);
            map.put("quantidade", obj[1]);
            return map;
        }).toList();
    }

    // 9) Veículos registrados na última semana
    @GetMapping("/last-week")
    public List<Vehicle> getVehiclesLastWeek() {
        return vehicleService.lastWeekVehicles();
    }

    // 10) Busca por marca e/ou década
    // Exemplo de uso:
    // /vehicles/search?marca=Ford
    // /vehicles/search?decada=1990
    // /vehicles/search?marca=Ford&decada=1990
    @GetMapping("/search")
    public List<Vehicle> searchVehicles(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Integer decada
    ) {
        // Caso a chamada venha com marca e década, faz intersecção
        // Aqui é só um exemplo simples; pode ser adaptado conforme necessidade
        if (marca != null && decada != null) {
            // Busca por marca e depois filtra a década
            return vehicleService.searchByMarca(marca).stream()
                    .filter(v -> (v.getAno() / 10) * 10 == decada)
                    .toList();
        } else if (marca != null) {
            return vehicleService.searchByMarca(marca);
        } else if (decada != null) {
            return vehicleService.searchByDecada(decada);
        }
        // Se não passar nenhum parâmetro, retorna tudo
        return vehicleService.findAll();
    }
}
