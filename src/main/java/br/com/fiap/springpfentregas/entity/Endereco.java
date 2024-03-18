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
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP_DEPOSITO")
    private String cep;

    @Column(name = "NUM_ENDERECO")
    private String numero;

    @Column(name = "COMP_DEPOSITO")
    private String complemento;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TB_PESSOA_ENDERECO",
            referencedColumnName = "ID_PESSOA_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO")
    )

    private Pessoa pessoa;
}
