package br.com.trees4cities.dto;

import java.math.BigDecimal;

public record ArvoresContribuicaoResponse(
        BigDecimal quantidadePlantio,
        BigDecimal quantidadeRastreio,
        BigDecimal iptuEconomizado
) {
}
