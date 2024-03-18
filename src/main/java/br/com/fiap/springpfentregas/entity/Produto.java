package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "ETIQ_PRODUTO")
    private String etiqueta;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "PESO_PRODUTO")
    private String peso;

    @Column(name = "LARG_PRODUTO")
    private Float largura;

    @Column(name = "ALT_PRODUTO")
    private Float altura;

    @Column(name = "PROF_PRODUTO")
    private Float profundidade;
}
