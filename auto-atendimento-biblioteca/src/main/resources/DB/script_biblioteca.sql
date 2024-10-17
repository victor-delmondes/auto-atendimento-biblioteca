CREATE TABLE USUARIOS (
ID INTEGER PRIMARY KEY AUTO_INCREMENT, 
nome VARCHAR(100), 
CPF VARCHAR(11), 
Endereco VARCHAR(200), 
Telefone VARCHAR(15), 
Cidade VARCHAR(100), 
Estado VARCHAR(2), 
EMail VARCHAR(100), 
Senha VARCHAR(100)
);

CREATE TABLE LIVROS (
    ID_Livros INTEGER PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(200),
    Autor VARCHAR(100),
    Quantidade INTEGER,
    ISBN VARCHAR(13),
    Editora VARCHAR(100),
    Ano_publicacao DATE
);

CREATE TABLE EMPRESTIMO (
    ID_Emprestimo INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_User INTEGER,
    ID_Livro INTEGER,
    Data_emprestimo DATE,
    Data_devolucao DATE,
    Status VARCHAR(50),
    fk_User_ID INTEGER,
    fk_Livros_ID_Livros INTEGER
);

CREATE TABLE ListaDesejos (
    ID_ListaDesejos INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_User INTEGER,
    ID_Livro INTEGER,
    fk_User_ID INTEGER,
    fk_Livros_ID_Livros INTEGER
);

-- Adicionando as chaves estrangeiras (Foreign Keys)
ALTER TABLE Emprestimo ADD CONSTRAINT FK_Emprestimo_User
    FOREIGN KEY (fk_User_ID)
    REFERENCES User (ID)
    ON DELETE CASCADE;

ALTER TABLE Emprestimo ADD CONSTRAINT FK_Emprestimo_Livros
    FOREIGN KEY (fk_Livros_ID_Livros)
    REFERENCES Livros (ID_Livros)
    ON DELETE CASCADE;

ALTER TABLE ListaDesejos ADD CONSTRAINT FK_ListaDesejos_User
    FOREIGN KEY (fk_User_ID)
    REFERENCES User (ID)
    ON DELETE CASCADE;

ALTER TABLE ListaDesejos ADD CONSTRAINT FK_ListaDesejos_Livros
    FOREIGN KEY (fk_Livros_ID_Livros)
    REFERENCES Livros (ID_Livros)
    ON DELETE CASCADE;
