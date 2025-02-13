package com.GiovannePDS7.transactionManagement_api.Controller;

import com.GiovannePDS7.transactionManagement_api.Business.Services.EstatisticasService;
import com.GiovannePDS7.transactionManagement_api.Controller.Dtos.EstatisticasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    public final EstatisticasService estatisticasService;

    @GetMapping
    @Operation(description = "Endpoint responsável por buscar estatísticas de transações")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro na busca de estatísticas de transações"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloTransacoes", required = false, defaultValue = "60") Integer intervaloTransacoes){
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloTransacoes));
    }
}
