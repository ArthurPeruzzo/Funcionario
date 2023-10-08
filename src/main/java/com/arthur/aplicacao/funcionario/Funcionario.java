package com.arthur.aplicacao.funcionario;

import com.arthur.aplicacao.funcionario.enums.Departamento;
import com.arthur.aplicacao.funcionario.enums.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "FUNCIONARIO")
@Getter @Setter
@SequenceGenerator(name="funcionario_seq", sequenceName="funcionario_seq", allocationSize=1)
public class Funcionario {

    @Id
    @ApiModelProperty("Identificador")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="funcionario_seq")
    @Column(name = "ID_FUNCIONARIO")
    private Long id;

    @Size(max = 30, min = 2, message = "O nome deve possuir entre 2 e 30 caracteres")
    @ApiModelProperty("Nome")
    @Pattern(regexp = "^[A-Z]+(.)*", message = "O nome deve começar com letra maiúscula")
    @Column(name = "NOME")
    @NotNull
    private String nome;

    @CPF(message = "CPF inválido!")
    @ApiModelProperty("CPF")
    @Column(name = "CPF")
    @NotNull
    private String cpf;

    @ApiModelProperty("Telefone")
    @Column(name = "TELEFONE")
    private String telefone;

    @ApiModelProperty("Email")
    @Email(message = "Email inválido!")
    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @ApiModelProperty("Data de admissão")
    @NotNull
    @Column(name = "DATA_ADMISSAO")
    private LocalDate dataAdmissao;

    @ApiModelProperty("Departamento")
    @NotNull
    @Column(name = "DEPARTAMENTO")
    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    @ApiModelProperty("Salário")
    @Column(name = "SALARIO")
    @NotNull
    private BigDecimal salario;

    @ApiModelProperty("Status")
    @Column(name = "STATUS")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

}
