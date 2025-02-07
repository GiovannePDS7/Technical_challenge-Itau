package com.GiovannePDS7.transactionManagement_api.Business.Services;

import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.EstatisticasResponseDTO;
import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.TransacaoRequestDTO;
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

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
       log.info("Iniciada busca de estatísticas de transações no intervalo de busca " + intervaloBusca);
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
        log.info("Estatísticas retornadas com sucesso");
        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(), estatisticasTransacoes.getSum(), estatisticasTransacoes.getAverage(), estatisticasTransacoes.getMin(), estatisticasTransacoes.getMax());
    }

}
