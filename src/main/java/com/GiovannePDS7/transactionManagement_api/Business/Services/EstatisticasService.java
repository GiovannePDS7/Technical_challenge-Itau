package com.GiovannePDS7.transactionManagement_api.Business.Services;

import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.EstatisticasResponseDTO;
import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(), estatisticasTransacoes.getSum(), estatisticasTransacoes.getAverage(), estatisticasTransacoes.getMin(), estatisticasTransacoes.getMax());
    }

}
