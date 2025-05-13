package br.com.gsw.livraria.model.mapper;

import br.com.gsw.livraria.model.dto.CapituloDto;
import br.com.gsw.livraria.model.entity.CapituloEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PaginaMapper.class)
public interface CapituloMapper {
    CapituloDto toDto(CapituloEntity entity);
    List<CapituloDto> toDtoList(List<CapituloEntity> capituloEntities);
}
