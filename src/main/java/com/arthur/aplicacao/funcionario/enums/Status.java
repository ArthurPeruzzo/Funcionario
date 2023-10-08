package com.arthur.aplicacao.funcionario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;
}
