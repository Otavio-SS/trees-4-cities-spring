package br.com.trees4cities.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlantioRequest {
    private String cpf;
    private String nome;
    private BigDecimal quantidadePlantio;
    private BigDecimal quantidadeRastreio;
}
