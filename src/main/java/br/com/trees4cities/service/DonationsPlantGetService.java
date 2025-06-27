package br.com.trees4cities.service;

import br.com.trees4cities.database.PlantioRepository;
import br.com.trees4cities.dto.ArvoresContribuicaoResponse;
import br.com.trees4cities.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DonationsPlantGetService {
    private final PlantioRepository repository;

    public DonationsPlantGetService(PlantioRepository repository) {
        this.repository = repository;
    }

    public ArvoresContribuicaoResponse findByCpf(String cpf) {
        var result = repository.findByCpf(cpf);

        if (result.isPresent()) {
            var plantio = result.get();

            return new ArvoresContribuicaoResponse(
                    plantio.getQuantidadePlantio(),
                    plantio.getQuantidadeRastreio(),
                    calculateIptuEconomizado(plantio.getQuantidadePlantio())
            );
        } else {
            throw new NotFoundException();
        }
    }

    private BigDecimal calculateIptuEconomizado(BigDecimal quantidadePlantio) {
        return quantidadePlantio.multiply(new BigDecimal("0.1")); // Example calculation
    }
}
