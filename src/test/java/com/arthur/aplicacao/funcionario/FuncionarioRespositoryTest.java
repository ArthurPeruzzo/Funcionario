package com.arthur.aplicacao.funcionario;

import com.arthur.aplicacao.funcionario.enums.Departamento;
import com.arthur.aplicacao.funcionario.enums.Status;
import com.arthur.aplicacao.funcionario.interfaces.FuncionarioQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionarioRespositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Test
    public void deveriaBuscarTodosOsFuncionarios(){
        Funcionario funcionario1 = funcionario1();
        funcionarioRepository.save(funcionario1);
        List<FuncionarioQuery> funcionarioResultadoPesquisa = funcionarioRepository.buscaTodosOsFuncionarios().stream().toList();
        assertNotNull(funcionarioResultadoPesquisa);
    }

    @Test
    public void deveriaEncontrarFuncionarioPorCpfOuNome(){
        Funcionario funcionario1 = funcionario1();
        funcionarioRepository.save(funcionario1);
        List<FuncionarioQuery> funcionarioResultadoPesquisaCpf = funcionarioRepository.buscaFuncionarioPorNomeOuCpf("43665555060").stream().toList();
        assertNotNull(funcionarioResultadoPesquisaCpf);

        List<FuncionarioQuery> funcionarioResultadoPesquisaNome = funcionarioRepository.buscaFuncionarioPorNomeOuCpf("Teste").stream().toList();
        assertNotNull(funcionarioResultadoPesquisaNome);
    }

    @Test
    public void deveriaSalvarFuncionario(){
        Funcionario funcionario = funcionario();
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        assertNotNull(funcionarioSalvo);
        assertEquals(funcionario.getCpf(), funcionarioSalvo.getCpf());
        assertEquals(funcionario.getEmail(), funcionarioSalvo.getEmail());
        assertEquals(funcionario.getNome(), funcionarioSalvo.getNome());
    }

    @Test
    public void deveriaAtualizarFuncionario(){
        Funcionario funcionario = funcionario();
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        BigDecimal salario = new BigDecimal(10000.00);
        funcionarioSalvo.setSalario(salario);

        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);

        assertNotNull(funcionarioAtualizado);
        assertEquals(funcionarioAtualizado.getSalario(), salario);
    }

    @Test
    public void deveriaBuscarFuncionarioPorId(){
        Funcionario funcionario = funcionario();
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        Funcionario funcionarioEncontrado = funcionarioRepository.findById(funcionarioSalvo.getFuncionarioId()).orElse(null);

        assertNotNull(funcionarioEncontrado);
        assertEquals(funcionarioEncontrado.getFuncionarioId(), funcionarioSalvo.getFuncionarioId());
    }

    @Test
    public void deveriaDeletarFuncionario(){
        Funcionario funcionario = funcionario();
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        Long funcionarioId = funcionarioSalvo.getFuncionarioId();

        funcionarioRepository.deleteById(funcionarioSalvo.getFuncionarioId());
        Funcionario funcionarioEncontrado = funcionarioRepository.findById(funcionarioId).orElse(null);
        assertNull(funcionarioEncontrado);
    }

    private Funcionario funcionario(){
        return Funcionario.builder()
                .nome("Arthur")
                .cpf("09581239936")
                .telefone("46999260326")
                .email("arthur@gmail.com")
                .dataAdmissao(LocalDate.now())
                .departamento(Departamento.DESENVOLVIMENTO)
                .salario(new BigDecimal("5000.00"))
                .status(Status.ATIVO)
                .build();
    }

    private Funcionario funcionario1(){
        return Funcionario.builder()
                .nome("Teste")
                .cpf("43665555060")
                .telefone("46999260326")
                .email("teste@hotmail.com")
                .dataAdmissao(LocalDate.now())
                .departamento(Departamento.DESENVOLVIMENTO)
                .salario(new BigDecimal("5000.00"))
                .status(Status.ATIVO)
                .build();
    }

}
