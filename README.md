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
