CREATE TABLE Usuarios
(
    ID       INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nome     VARCHAR(100),
    E_Mail   VARCHAR(100),
    Senha    VARCHAR(100),
    CPF      VARCHAR(14),
    Endereco VARCHAR(200),
    Telefone VARCHAR(20),
    Cidade   VARCHAR(100),
    Estado   VARCHAR(2),
    Tipo     BOOLEAN
);

CREATE TABLE Livros
(
    ID_Livros      INTEGER PRIMARY KEY AUTO_INCREMENT,
    Titulo         VARCHAR(200),
    Autor          VARCHAR(100),
    Quantidade     INTEGER,
    ISBN           VARCHAR(13),
    Editora        VARCHAR(100),
    Ano_publicacao INTEGER,
    Categoria      VARCHAR(100),
    Sinopse        VARCHAR(20000),
    Image          VARCHAR(300),
    location       VARCHAR(200)
);

CREATE TABLE Emprestimo
(
    ID_Emprestimo   INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_Usuarios     INTEGER,
    ID_Livro        INTEGER,
    Data_emprestimo DATE,
    Data_devolucao  DATE,
    Status          VARCHAR(50),
    FOREIGN KEY (ID_Usuarios) REFERENCES Usuarios (ID) ON DELETE CASCADE,
    FOREIGN KEY (ID_Livro) REFERENCES Livros (ID_Livros) ON DELETE CASCADE
);


CREATE TABLE ListaDesejos
(
    ID_ListaDesejos     INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_User             INTEGER,
    ID_Livro            INTEGER,
    FOREIGN KEY (ID_User) REFERENCES Usuarios (ID) ON DELETE CASCADE,
    FOREIGN KEY (ID_Livro) REFERENCES Livros (ID_Livros) ON DELETE CASCADE
);