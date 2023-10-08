package com.arthur.aplicacao.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(
        value = "SELECT f.* " +
                "FROM Funcionario f " +
                " where f.funcionarioid is not null" +
                " order by f.funcionarioid",
        nativeQuery = true)
    List<Funcionario> buscaTodosOsFuncionarios();

    @Query(
        value = "SELECT f.* " +
                "FROM Funcionario f " +
                " where f.nome like %:filtro%" +
                " or f.cpf like %:filtro%",
        nativeQuery = true)
    List<Funcionario> buscaFuncionarioPorNomeOuCpf(@Param("filtro") String filtro);
}
