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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
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

        return toDto(livro);
    }

    @Override
    public byte[] obterLivroPdf(Long id) {
        try {
            var livro = this.livroRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Livro com ID " + id + " não encontrado"));

            var livroDto = toDto(livro);
            var mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var jsonString = mapper.writeValueAsString(livroDto);

            var out = new ByteArrayOutputStream();
            var writer = new PdfWriter(out);
            var pdfDoc = new PdfDocument(writer);
            var document = new Document(pdfDoc);

            document.add(new Paragraph("Livro em formato JSON").setBold().setFontSize(14));
            document.add(new Paragraph(jsonString).setFontSize(10));
            document.close();

            var pdfBytes = out.toByteArray();

            return pdfBytes;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }
    }

    private LivroDto toDto(LivroEntity livro){
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
