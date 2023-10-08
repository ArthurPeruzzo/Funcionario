package com.arthur.aplicacao.funcionario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario inserirFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Funcionario> buscarTodosOsFuncionario() {
        return funcionarioRepository.buscaTodosOsFuncionarios();
    }

    @Override
    public List<Funcionario> buscarFuncionarioPorNomeOuCpf(String filtro) {
        return funcionarioRepository.buscaFuncionarioPorNomeOuCpf(filtro);
    }

    @Override
    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
