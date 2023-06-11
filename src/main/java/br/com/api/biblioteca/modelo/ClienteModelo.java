package br.com.api.biblioteca.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_clientes")
public class ClienteModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    @Column(columnDefinition = "VARCHAR(15)")
    private String nome;
    @Column(columnDefinition = "VARCHAR(15)")
    private String sobrenome;
    private Integer telefone;
    @Column(columnDefinition = "VARCHAR(25)")
    private String bairro;
    @Column(columnDefinition = "VARCHAR(25)")
    private String rua;
}
