CREATE TABLE Usuarios (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    E_Mail VARCHAR(100),
    Senha VARCHAR(100),
    CPF VARCHAR(11),
    Endereco VARCHAR(200),
    Telefone VARCHAR(15),
    Cidade VARCHAR(100),
    Estado VARCHAR(2),
    Tipo BOOLEAN
);

CREATE TABLE Livros (
    ID_Livros INTEGER PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(200),
    Autor VARCHAR(100),
    Quantidade INTEGER,
    ISBN VARCHAR(13),
    Editora VARCHAR(100),
    Ano_publicacao INTEGER,
    Categoria VARCHAR(100),
    Sinopse VARCHAR(20000)
);

CREATE TABLE Emprestimo (
    ID_Emprestimo INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_Usuarios INTEGER,
    ID_Livro INTEGER,
    Data_emprestimo DATE,
    Data_devolucao DATE,
    Status VARCHAR(50),
    fk_User_ID INTEGER,
    fk_Livros_ID_Livros INTEGER,
    FOREIGN KEY (fk_User_ID) REFERENCES Usuarios(ID) ON DELETE CASCADE,
    FOREIGN KEY (fk_Livros_ID_Livros) REFERENCES Livros(ID_Livros) ON DELETE CASCADE
);

CREATE TABLE ListaDesejos (
    ID_ListaDesejos INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_User INTEGER,
    ID_Livro INTEGER,
    fk_User_ID INTEGER,
    fk_Livros_ID_Livros INTEGER,
    FOREIGN KEY (fk_User_ID) REFERENCES Usuarios(ID) ON DELETE CASCADE,
    FOREIGN KEY (fk_Livros_ID_Livros) REFERENCES Livros(ID_Livros) ON DELETE CASCADE
);