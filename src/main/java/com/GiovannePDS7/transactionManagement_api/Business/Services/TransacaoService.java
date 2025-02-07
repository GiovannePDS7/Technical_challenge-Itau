package com.GiovannePDS7.transactionManagement_api.Business.Services;

import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.TransacaoRequestDTO;
import com.GiovannePDS7.transactionManagement_api.Infrastructure.Exceptions.UnprocessableEntity;
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
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void AdicionarTransacoes (TransacaoRequestDTO dto){
        log.info("Processamento de gravação de transações iniciado " + dto);
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maior que a atual");
            throw new UnprocessableEntity("Data e hora maior que a atual");
        }
        if (dto.valor() < 0){
            log.error("Valor inferior a 0");
            throw new UnprocessableEntity("Valor não pode ser inferior a 0");
        }
        log.info("Transações adicionadas com sucesso");
        listaTransacoes.add(dto);
    }

    public void DeletarTransacoes(){
        log.info("Deletando lista de transações");
        listaTransacoes.clear();
        log.info("Transações deletadas com sucesso");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloTransacoes){
        log.info("Buscando transações pelo tempo: " + intervaloTransacoes);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloTransacoes);
        log.info("Retorno de transações com sucesso");
        return listaTransacoes.stream().filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo)).toList();
    }
}
