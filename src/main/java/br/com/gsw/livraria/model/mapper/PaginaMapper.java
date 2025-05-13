package br.com.gsw.livraria.model.mapper;

import br.com.gsw.livraria.model.dto.CapituloDto;
import br.com.gsw.livraria.model.dto.PaginaDto;
import br.com.gsw.livraria.model.entity.CapituloEntity;
import br.com.gsw.livraria.model.entity.PaginaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ConteudoMapper.class)
public interface PaginaMapper {
    PaginaDto toDto(PaginaEntity entity);
    List<PaginaDto> toDtoList(List<PaginaEntity> paginaEntities);
}