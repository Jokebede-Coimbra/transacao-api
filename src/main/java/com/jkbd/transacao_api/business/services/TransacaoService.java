package com.jkbd.transacao_api.business.services;

import com.jkbd.transacao_api.controller.dtos.TrasacaoRequestDTO;
import com.jkbd.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TrasacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTrasacoes(TrasacaoRequestDTO dto) {

        log.info("Iniciado o procesamento de gravar transações");

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data e hora maiores que a data atuais");
        }
        if(dto.valor() < 0) {
            log.error("Valor não pode ser menor que 0");
            throw new UnprocessableEntity("Valor não pode ser menor que 0");
        }

        listaTransacoes.remove(dto);
    }
}
