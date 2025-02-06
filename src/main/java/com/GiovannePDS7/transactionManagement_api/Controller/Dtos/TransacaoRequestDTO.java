package com.GiovannePDS7.transactionManagement_api.Controller.Dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
