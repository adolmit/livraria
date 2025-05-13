package br.com.gsw.livraria.model.dto;

import java.util.List;

public record CapituloDto(Long id, Integer numero, String titulo, List<PaginaDto> paginas) {}
