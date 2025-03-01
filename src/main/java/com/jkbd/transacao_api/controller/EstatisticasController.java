package com.jkbd.transacao_api.controller;

import com.jkbd.transacao_api.business.services.EstatisticasService;
import com.jkbd.transacao_api.controller.dtos.EstatisticasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private EstatisticasService estatisticasService;

    @GetMapping
    @Operation(
            summary = "Buscar uma transação",
            description = "Endpoint responsável por buscar estatisticas de transações"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca de estatisticas de transações"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {
        estatisticasService.calcularEstatisticasTrasacoes(intervaloBusca);
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTrasacoes(intervaloBusca));
    }
}
