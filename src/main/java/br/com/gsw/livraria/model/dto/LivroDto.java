package br.com.gsw.livraria.model.dto;


import java.util.List;

public record LivroDto(Long id, String titulo, String autor, String categoria, List<CapituloDto> capitulos) {}

