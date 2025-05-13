package br.com.gsw.livraria.model.mapper;

import br.com.gsw.livraria.model.dto.ConteudoDto;
import br.com.gsw.livraria.model.entity.ConteudoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConteudoMapper {
    ConteudoDto toDto(ConteudoEntity entity);
}