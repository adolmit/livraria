package br.com.gsw.livraria.controller.livro;

import br.com.gsw.livraria.model.dto.LivroDto;
import br.com.gsw.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroControllerImpl implements LivroController{

    @Autowired
    private LivroService livroService;

    @Override
    public ResponseEntity<LivroDto> obterLivro(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.livroService.obterLivro(id));
    }

    @Override
    public ResponseEntity<byte[]> obterLivroPdf(Long id) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline()
                .filename("livro_" + id + ".pdf")
                .build());

        return new ResponseEntity<>(this.livroService.obterLivroPdf(id), headers, HttpStatus.OK);
    }
}
