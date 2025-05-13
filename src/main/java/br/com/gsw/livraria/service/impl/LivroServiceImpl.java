package br.com.gsw.livraria.service.impl;

import br.com.gsw.livraria.exception.ResourceNotFoundException;
import br.com.gsw.livraria.model.dto.CapituloDto;
import br.com.gsw.livraria.model.dto.ConteudoDto;
import br.com.gsw.livraria.model.dto.LivroDto;
import br.com.gsw.livraria.model.dto.PaginaDto;
import br.com.gsw.livraria.model.entity.LivroEntity;
import br.com.gsw.livraria.model.mapper.LivroMapper;
import br.com.gsw.livraria.repository.LivroRepository;
import br.com.gsw.livraria.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    @Autowired
    private  LivroRepository livroRepository;
    @Autowired
    private  LivroMapper livroMapper;

    @Override
    public LivroDto obterLivro(Long id) {
        LivroEntity livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro com ID " + id + " não encontrado"));

        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getCategoria(),
                livro.getCapitulos()
                        .stream().map(
                                it -> new CapituloDto(it.getId(),
                                        it.getNumero(),
                                        it.getTitulo(),
                                        it.getPaginas().stream().map(pag -> new PaginaDto(pag.getId(),
                                                    pag.getNumero(),
                                                    new ConteudoDto(pag.getConteudo().getId(),
                                                            pag.getConteudo().getTexto())
                                                )
                                        ).collect(Collectors.toList())
                                )
                        ).collect(Collectors.toList())
                );
    }
}
