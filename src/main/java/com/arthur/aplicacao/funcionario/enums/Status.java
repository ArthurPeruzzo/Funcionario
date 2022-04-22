package com.arthur.aplicacao.funcionario.enums;

public enum Status {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }
}
