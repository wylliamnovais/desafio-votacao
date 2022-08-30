package br.com.wylliam.desafio.controller;

import br.com.wylliam.desafio.domain.entity.dto.AssociadoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.AssociadoResponseDTO;
import br.com.wylliam.desafio.exception.ResponseError;
import br.com.wylliam.desafio.service.AssociadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("associado")
@Tag(name = "Associado", description = "Operações para Gerenciamento dos Associados.")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @Operation(summary = "Endpoint Responsável por Cadastrar o Associado.", description = "Método para cadastar o associado.", tags = {"Associado"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Id do Associado Cadastrado", content = @Content(schema = @Schema(implementation = AssociadoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    @PostMapping
    public ResponseEntity<?> votacao(@RequestBody AssociadoRequestDTO dto) {
        return ResponseEntity.ok(associadoService.cadastrarAssociado(dto));
    }
}
