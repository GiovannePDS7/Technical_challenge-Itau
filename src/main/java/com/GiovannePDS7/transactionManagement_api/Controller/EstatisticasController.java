package com.GiovannePDS7.transactionManagement_api.Controller;

import com.GiovannePDS7.transactionManagement_api.Business.Services.EstatisticasService;
import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.EstatisticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    public final EstatisticasService estatisticasService;

    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloTransacoes", required = false, defaultValue = "60") Integer intervaloTransacoes){
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloTransacoes));
    }
}
