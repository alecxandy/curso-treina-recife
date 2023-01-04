package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Campo nome é obrigatorio")
    @Column(name = "nome", length = 45, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    @NotEmpty(message = "Campo CPF é obrigatorio")
    @CPF(message = "Informe um CPF valido!")
    private String cpf;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "endereco", length = 45)
    private String endereco;


}
