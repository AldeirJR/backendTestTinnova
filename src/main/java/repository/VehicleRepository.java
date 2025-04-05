package com.example.cadastro_veiculos.repository;

import com.example.cadastro_veiculos.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Contagem de veículos não vendidos
    long countByVendidoFalse();

    // Veículos criados depois de uma data específica
    List<Vehicle> findByCreatedAtAfter(LocalDateTime dateTime);

    // Distribuição por década (usando JPQL)
    @Query("SELECT FLOOR(v.ano/10)*10 AS decada, COUNT(v) " +
           "FROM Vehicle v " +
           "GROUP BY FLOOR(v.ano/10)*10 " +
           "ORDER BY decada")
    List<Object[]> findDistributionByDecade();

    // Distribuição por marca
    @Query("SELECT v.marca, COUNT(v) FROM Vehicle v GROUP BY v.marca ORDER BY v.marca")
    List<Object[]> findDistributionByMarca();

    // Busca por marca e ano (década).  
    // Exemplo de consulta simples, mas poderia ser customizada de diversas formas.
    List<Vehicle> findByMarcaIgnoreCase(String marca);

    // Se quiser buscar pela década, você pode fazer uma query manual ou filtrar em nível de serviço.
    // Exemplo de query JPQL:
    @Query("SELECT v FROM Vehicle v WHERE FLOOR(v.ano/10)*10 = :decada")
    List<Vehicle> findByDecada(int decada);
}
