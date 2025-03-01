package com.jkbd.transacao_api.controller;

import com.jkbd.transacao_api.business.services.EstatisticasService;
import com.jkbd.transacao_api.controller.dtos.EstatisticasResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private EstatisticasService estatisticasService;


    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {
        estatisticasService.calcularEstatisticasTrasacoes(intervaloBusca);
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTrasacoes(intervaloBusca));
    }
}
