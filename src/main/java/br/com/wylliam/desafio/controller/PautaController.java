package br.com.wylliam.desafio.controller;

import br.com.wylliam.desafio.domain.entity.dto.PautaRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.PautaResponseDTO;
import br.com.wylliam.desafio.exception.ResponseError;
import br.com.wylliam.desafio.service.PautaService;
import br.com.wylliam.desafio.service.VotacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/pauta")
@Tag(name = "Pauta", description = "Operações para Gerenciamento das Pautas.")
public class PautaController {


    @Autowired
    private PautaService pautaService;

    @PostMapping
    @Operation(summary = "Endpoint Responsável por criar a Pauta.", description = "Método para criar a pauta.", tags = {"Pauta"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pauta Cadastrada", content = @Content(schema = @Schema(implementation = PautaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    public ResponseEntity<?> cadastrarPauta(@RequestBody PautaRequestDTO dto) {
        return ResponseEntity.ok(pautaService.cadastrarPauta(dto));
    }

    @GetMapping
    @Operation(summary = "Endpoint Responsável por Listar as Pautas.", description = "Método para listas as pautas.", tags = {"Pauta"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pauta Cadastrada", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PautaResponseDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    public ResponseEntity<?> consultarPautas() {
        return ResponseEntity.ok(pautaService.consultarPautas());
    }

    @PutMapping(value = "/{id_pauta}")
    @Operation(summary = "Endpoint Responsável por Abrir a Votação da Pauta.", description = "Método para abrir a votação da pautas.", tags = {"Pauta"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Votação Iniciada com Sucesso", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
            @ApiResponse(responseCode = "400", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    public ResponseEntity<?> abrirVotacao(
            @Parameter(name = "id_pauta", description = "Id da pauta.", required = true) @PathVariable(name = "id_pauta") Long idPauta,
            @Parameter(name = "tempo_limite", description = "Tempo Limite de Votação Aberta (Tempo em Minutos).", required = true) @RequestParam(value = "tempo_limite", required = true) Integer tempoLimite
    ) {
        return ResponseEntity.ok(pautaService.abrirVotacao(idPauta, tempoLimite));
    }

}
