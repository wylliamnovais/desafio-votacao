package br.com.wylliam.desafio.controller;

import br.com.wylliam.desafio.domain.entity.dto.PautaRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.VotoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.VotoResponseDTO;
import br.com.wylliam.desafio.exception.ResponseError;
import br.com.wylliam.desafio.service.VotacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/votacao")
@Tag(name = "Votação", description = "Operações para Gerenciamento das Votações.")
public class VotacaoController {


    @Autowired
    private VotacaoService votacaoService;

    @PostMapping
    @Operation(summary = "Endpoint Responsável por votar na Pauta.", description = "Método para enviar a votação do associado a pauta.", tags = {"Votação"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voto computado com Sucesso.", content = @Content(schema = @Schema(implementation = VotoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    public ResponseEntity<?> votacao(@RequestBody VotoRequestDTO dto) {
        return ResponseEntity.ok(votacaoService.votar(dto));
    }

}
