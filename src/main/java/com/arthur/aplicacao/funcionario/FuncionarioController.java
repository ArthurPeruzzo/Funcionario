package com.arthur.aplicacao.funcionario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Funcionário")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Buscar funcionário por id")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable(value = "id") Long id){
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/buscar-todos")
    @ApiOperation(value = "Buscar todos os funcionários")
    public ResponseEntity<List<Funcionario>> buscarTodosOsFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.buscarTodosOsFuncionario();
        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping("/buscar-todos/{filtro}")
    @ApiOperation(value = "Buscar funcionários por cpf ou nome")
    public ResponseEntity<List<Funcionario>> buscarFuncionariosPorCpfOuNome(@PathVariable(value = "filtro") String filtro){
        List<Funcionario> funcionarios = funcionarioService.buscarFuncionarioPorNomeOuCpf(filtro);
        return ResponseEntity.ok().body(funcionarios);
    }

    @PostMapping("/inserir")
    @ApiOperation(value = "Inserir funcionário")
    public ResponseEntity<Funcionario> inserirFuncionario(@Valid @RequestBody Funcionario funcionario){
        Funcionario funcionarioResultado = funcionarioService.inserirFuncionario(funcionario);
            return ResponseEntity.ok().body(funcionarioResultado);
    }

    @PutMapping("/atualizar")
    @ApiOperation(value = "Atualizar funcionário")
    public ResponseEntity<Funcionario> atualizarFuncionario(@Valid @RequestBody Funcionario funcionario){
        Funcionario funcionarioResultado = funcionarioService.atualizarFuncionario(funcionario);
            return ResponseEntity.ok().body(funcionarioResultado);
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation(value = "Deletar funcionário por id")
    public void deletarFuncionario(@PathVariable(value = "id") Long id){
        funcionarioService.deletarFuncionario(id);
    }

}
