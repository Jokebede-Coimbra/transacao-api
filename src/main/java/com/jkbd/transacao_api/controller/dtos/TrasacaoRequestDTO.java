package com.jkbd.transacao_api.controller.dtos;

import java.time.OffsetDateTime;

public record TrasacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
