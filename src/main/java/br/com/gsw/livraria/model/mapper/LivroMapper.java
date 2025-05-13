package br.com.gsw.livraria.model.mapper;

import br.com.gsw.livraria.model.dto.LivroDto;
import br.com.gsw.livraria.model.entity.LivroEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CapituloMapper.class)
public interface LivroMapper {
    LivroDto toDto(LivroEntity entity);
    List<LivroDto> toDtoList(List<LivroEntity> entities);
}
