package com.arthur.aplicacao.funcionario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Departamento {

    RH("Recursos Humanos"),
    DESENVOLVIMENTO("Desenvolvimento");

    private final String descricao;
}
