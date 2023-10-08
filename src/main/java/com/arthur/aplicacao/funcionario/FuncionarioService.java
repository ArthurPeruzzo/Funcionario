package com.arthur.aplicacao.funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario inserirFuncionario(Funcionario funcionario);
    Funcionario buscarFuncionarioPorId(Long id);
    List<Funcionario> buscarTodosOsFuncionario();
    List<Funcionario> buscarFuncionarioPorNomeOuCpf(String filtro);
    Funcionario atualizarFuncionario(Funcionario funcionario);
    void deletarFuncionario(Long id);
}
