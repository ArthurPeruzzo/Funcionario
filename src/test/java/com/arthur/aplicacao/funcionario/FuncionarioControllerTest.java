package com.arthur.aplicacao.funcionario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void DeveRetornarError400SeNomeComecaComLetraMinuscula() throws Exception {
        URI uri = new URI("/api/funcionario/inserir");
        String jsonFuncionario = funcionarioTesteNomeLetraMinuscula();

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(jsonFuncionario)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    private String funcionarioTesteNomeLetraMinuscula(){
        return "{" +
                "\"nome\": \"arthur\"," +
                "\"cpf\": \"09581239936\","+
                "\"telefone\": \"46999260326\"," +
                "\"email\": \"arthur@gmail.com\","+
                "\"dataAdmissao\": \"2001-09-28\"," +
                "\"departamento\": \"DESENVOLVIMENTO\"," +
                "\"salario\": 5000.00,"+
                "\"status\": \"ATIVO\"" +
                "}";
    }

}
