package br.com.gsw.livraria.repository;

import br.com.gsw.livraria.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    @EntityGraph(attributePaths = {"capitulos", "capitulos.paginas", "capitulos.paginas.conteudo"})
    Optional<LivroEntity> findById(Long id);
}
