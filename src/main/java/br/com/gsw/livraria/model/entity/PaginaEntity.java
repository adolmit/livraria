package br.com.gsw.livraria.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "capitulo_id", nullable = false)
    private CapituloEntity capitulo;

    @OneToOne(mappedBy = "pagina", cascade = CascadeType.ALL, orphanRemoval = true)
    private ConteudoEntity conteudo;
}
