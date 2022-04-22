package com.arthur.aplicacao.funcionario;

import com.arthur.aplicacao.funcionario.interfaces.FuncionarioQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario inserirFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<FuncionarioQuery> buscarTodosOsFuncionario() {
        List<FuncionarioQuery> funcionarios = funcionarioRepository.buscaTodosOsFuncionarios().stream().toList();
        return funcionarios;
    }

    public List<FuncionarioQuery> buscarFuncionarioPorNomeOuCpf(String filtro) {
        List<FuncionarioQuery> funcionarios = funcionarioRepository.buscaFuncionarioPorNomeOuCpf(filtro).stream().toList();
        return funcionarios;
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
