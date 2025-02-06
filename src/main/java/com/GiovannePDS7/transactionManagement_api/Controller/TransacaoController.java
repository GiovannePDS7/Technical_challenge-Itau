package com.GiovannePDS7.transactionManagement_api.Controller;

import com.GiovannePDS7.transactionManagement_api.Business.Services.TransacaoService;
import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> AdicionarTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.AdicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.DeletarTransacoes();
        return ResponseEntity.ok().build();
    }
}
