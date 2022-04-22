package com.arthur.aplicacao.funcionario;

import com.arthur.aplicacao.funcionario.interfaces.FuncionarioQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(
        value = "SELECT f.funcionarioid, f.nome, f.cpf, f.email " +
                "FROM Funcionario f " +
                " where f.funcionarioid is not null" +
                " order by f.funcionarioid",
        nativeQuery = true)
    Collection<FuncionarioQuery> buscaTodosOsFuncionarios();

    @Query(
        value = "SELECT f.funcionarioid, f.nome, f.cpf, f.email " +
                "FROM Funcionario f " +
                " where f.nome like %:filtro%" +
                " or f.cpf like %:filtro%",
        nativeQuery = true)
    Collection<FuncionarioQuery> buscaFuncionarioPorNomeOuCpf(@Param("filtro") String filtro);
}
