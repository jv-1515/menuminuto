/* Serial = inteiro e autoincrement */
CREATE TABLE IF NOT EXISTS cliente (
    id serial PRIMARY KEY, 
    nome varchar(50),
    email varchar(50),
    senha varchar(50)
);

CREATE TABLE IF NOT EXISTS receitas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR (50),
    descricao VARCHAR (100),
    preparo INT,
    imagem TEXT
);
        -- comando magico: ( drop schema public; )