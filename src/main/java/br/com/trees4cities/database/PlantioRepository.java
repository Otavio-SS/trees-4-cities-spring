package br.com.trees4cities.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantioRepository extends JpaRepository<PlantioEntity, Long> {
    Optional<PlantioEntity> findByCpf(String cpf);
}