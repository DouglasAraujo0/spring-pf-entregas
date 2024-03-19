package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TB_VIAGEM")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
    @SequenceGenerator(name = "SQ_VIAGEM", sequenceName = "SQ_VIAGEM", allocationSize = 1)
    @Column(name = "ID_VIAGEM")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CP_PRODUTOS",
            joinColumns = {
                    @JoinColumn(
                            name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_PRODUTOS_VIAGEM"
                            )

                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PRODUTOS"
                            )
                    )
            }
    )
    private List<Produto> produtos = new ArrayList<>();



    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_CP_PASSAGEIROS",
            joinColumns = {
                    @JoinColumn(
                            name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_PASSAGEIRO_VIAGEM"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PASSAGEIRO",
                            referencedColumnName = "ID_PASSAGEIRO",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PASSAGEIRO"
                            )
                    )
            }

    )
    private Set<Passageiro> passageiros = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(
            name = "ID_CLIENTE",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_VIAGEM_CLIENTE")
    )
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "ID_ORIGEM", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_ORIGEM"))
    private Endereco origem;

    @ManyToOne
    @JoinColumn(name = "ID_DESTINO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_DESTINO"))
    private Endereco destino;

    @Column(name =  "SAIDA")
    private LocalDateTime saida;

    @Column(name =  "CHEGADA")
    private LocalDateTime chegada;
}
