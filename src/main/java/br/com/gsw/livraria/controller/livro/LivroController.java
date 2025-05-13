package br.com.gsw.livraria.controller.livro;

import br.com.gsw.livraria.model.dto.ErroDto;
import br.com.gsw.livraria.model.dto.LivroDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Livros", description = "Gerenciamento de livros")
@RequestMapping("/livros")
public interface LivroController {

    @GetMapping(value = "/{id}")
    @Operation(summary = "Informações de um livro",
            description = "Informações de um livro",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Solicitação exitosa",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = LivroDto.class)))),
                    @ApiResponse(responseCode = "400", description = "Solicitação incorrecta",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErroDto.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErroDto.class)))
            })
    ResponseEntity<LivroDto> obterLivro(@PathVariable("id") Long id);
}
