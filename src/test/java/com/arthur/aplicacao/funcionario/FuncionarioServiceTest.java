package com.arthur.aplicacao.funcionario;

import com.arthur.aplicacao.funcionario.enums.Departamento;
import com.arthur.aplicacao.funcionario.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FuncionarioServiceTest {

    FuncionarioServiceImpl funcionarioService;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);
    }

    @Test
    void deveInserirFuncionario() {
        Funcionario funcionario = funcionario();
        funcionarioService.inserirFuncionario(funcionario);
        verify(funcionarioRepository, times(1)).save(funcionario);
    }

    @Test
    void buscarFuncionarioPorId() {
        Funcionario funcionario = funcionario();
        when(funcionarioRepository.findById(funcionario.getId())).thenReturn(of(funcionario));
        Funcionario func = funcionarioService.buscarFuncionarioPorId(funcionario.getId());
        assertEquals(funcionario, func);
        verify(funcionarioRepository, times(1)).findById(funcionario.getId());
    }

    @Test
    void atualizarFuncionario() {
        Funcionario funcionario = funcionario();
        funcionarioService.atualizarFuncionario(funcionario);
        verify(funcionarioRepository, times(1)).save(funcionario);
    }

    @Test
    void deletarFuncionario() {
        Funcionario funcionario = funcionario();
        funcionarioService.deletarFuncionario(funcionario.getId());
        verify(funcionarioRepository, times(1)).deleteById(funcionario.getId());
    }

    private Funcionario funcionario(){
        return Funcionario.builder()
                .id(1L)
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

}
