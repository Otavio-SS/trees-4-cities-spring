package br.com.trees4cities.service;

import br.com.trees4cities.database.PlantioEntity;
import br.com.trees4cities.database.PlantioRepository;
import br.com.trees4cities.dto.PlantioRequest;
import org.springframework.stereotype.Service;

@Service
public class DonationsPlantPostService {
    private final PlantioRepository repository;

    public DonationsPlantPostService(PlantioRepository repository) {
        this.repository = repository;
    }

    public PlantioEntity savePlantio(PlantioRequest request) {
        var plantio = PlantioEntity.builder()
                .cpf(request.getCpf())
                .nome(request.getNome())
                .quantidadePlantio(request.getQuantidadePlantio())
                .quantidadeRastreio(request.getQuantidadeRastreio())
                .build();

        return repository.save(plantio);
    }
}