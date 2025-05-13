package br.com.gsw.livraria.service;

import br.com.gsw.livraria.model.dto.LivroDto;

public interface LivroService {
    LivroDto obterLivro(Long id);
    byte[] obterLivroPdf(Long id);
}
