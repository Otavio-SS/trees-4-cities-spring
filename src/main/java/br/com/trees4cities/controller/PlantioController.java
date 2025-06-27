package br.com.trees4cities.controller;

import br.com.trees4cities.dto.PlantioRequest;
import br.com.trees4cities.exception.NotFoundException;
import br.com.trees4cities.service.DonationsPlantGetService;
import br.com.trees4cities.service.DonationsPlantPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/donations/plant", produces = "application/json")
public class PlantioController {
    private final DonationsPlantPostService donationsPlantPostService;
    private final DonationsPlantGetService donationsPlantGetService;

    public PlantioController(DonationsPlantPostService donationsPlantPostService, DonationsPlantGetService donationsPlantGetService) {
        this.donationsPlantPostService = donationsPlantPostService;
        this.donationsPlantGetService = donationsPlantGetService;
    }

    @Operation(summary = "GET /donations/plant", description = "Retorna XYZ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Descricao sucesso"),
            @ApiResponse(responseCode = "404", description = "Descricao erro"),
            @ApiResponse(responseCode = "500", description = "Descricao erro"),
    })
    @GetMapping
    public ResponseEntity<Object> getArvoresContribuicao(@RequestHeader("CPF") String cpf) {
        try {
            return ResponseEntity.ok().body(donationsPlantGetService.findByCpf(cpf));
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "POST /donations/plant", description = "Cria XYZ")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Descricao sucesso"),
            @ApiResponse(responseCode = "500", description = "Descricao erro"),
    })
    @PostMapping
    public ResponseEntity<Object> postArvoresContribuicao(@RequestBody PlantioRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(donationsPlantPostService.savePlantio(request));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
