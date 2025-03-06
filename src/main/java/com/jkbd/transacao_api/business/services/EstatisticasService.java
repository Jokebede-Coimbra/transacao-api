package com.jkbd.transacao_api.business.services;

import com.jkbd.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.jkbd.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {

        log.info("Iniciada busca de estatistica de gravar transações " + intervaloBusca);

        long start = System.currentTimeMillis();

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes
                .stream()
                .mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();

        long finish = System.currentTimeMillis();
        long tempoRequisicao = finish - start;
        System.out.println("Tempo de requisição: " + tempoRequisicao + "milissegundos");

        log.info("Estatisticas retornadas com sucesso");

        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());

    }
}
