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
@Table(name = "TB_PASSAGEIRO")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASSAGEIRO")
    @SequenceGenerator(name = "SQ_PASSAGEIRO", sequenceName = "SQ_PASSAGEIRO", allocationSize = 1)
    @Column(name = "ID_PASSAGEIRO")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TB_PESSOA_ENDERECO",
            referencedColumnName = "ID_PESSOA_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO")
    )

    private Pessoa pessoa;

}
