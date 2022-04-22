# FuncionarioAPI

Fala dev!

Sugiro clonar o repositório e executá-lo localmente para evitar possíveis problemas, qualquer dúvida, por favor me infome.

Irei comentar brevemente sobre as minhas decisões neste projeto.

Para documentação da API, decidi usar o Swagger pela facilidade de consumo e visualização dos serviços.

Utilizei também o Flyway para subir os scripts no banco de dados. Com isso tenho um versionamento dos scripts que foram criados
e a facilidade de criar a estrutura do banco.

Criei uniques para o campo de CPF e Email com o objetivo de deixar o sistema mais robusto, evitando registros duplicados.

Também utilizei o Lombok para evitar a geração de getter, setter e contrutores, por exemplo.

Em relação aos Enums, tomei a decisão de salvar os mesmos como string em banco, por conta de ser uma aplicação pequena e ser mais facil de implementar.

utilizei o PostgreSQL como banco de dados por já trabalhar com ele.

Para inicializar a aplicação somente será necessário configurar um banco postgres localmente.
No arquivo application.properties já está configurado tudo o que precisa. Somente será necessário criar um banco na mesma porta e com o mesmo nome, caso deseje.

Sinta-se à vontade para questionar!
