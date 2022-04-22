package com.arthur.aplicacao.funcionario.enums;

import lombok.Getter;

@Getter
public enum Departamento {

    RH("Recursos Humanos"),
    DESENVOLVIMENTO("Desenvolvimento");

    private String descricao;

    Departamento(String descricao) {
        this.descricao = descricao;
    }

}
