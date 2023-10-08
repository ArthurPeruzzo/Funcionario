CREATE TYPE DEPARTAMENTO_ENUM AS ENUM ('RH', 'DESENVOLVIMENTO');
CREATE TYPE STATUS_ENUM AS ENUM ('ATIVO', 'INATIVO');
CREATE SEQUENCE FUNCIONARIO_SEQ;

CREATE TABLE IF NOT EXISTS FUNCIONARIO(
    "ID_FUNCIONARIO" NUMERIC(20) NOT NULL,
    "NOME" VARCHAR(30) NOT NULL,
    "CPF" VARCHAR(11) NOT NULL,
    "TELEFONE" VARCHAR(11) NULL,
    "EMAIL" VARCHAR(30) NOT NULL,
    "DATA_ADMISSAO" DATE NOT NULL,
    "DEPARTAMENTO" DEPARTAMENTO_ENUM NOT NULL,
    "SALARIO" NUMERIC(11,2) NOT NULL,
    "STATUS" STATUS_ENUM NOT NULL,
    CONSTRAINT PK_FUNCIONARIO PRIMARY KEY ("ID_FUNCIONARIO"),
    CONSTRAINT UN_CPF UNIQUE ("CPF"),
    CONSTRAINT UN_EMAIL UNIQUE ("EMAIL")
);

COMMENT ON TABLE FUNCIONARIO IS 'Tabela para armazenar informações sobre funcionários.';