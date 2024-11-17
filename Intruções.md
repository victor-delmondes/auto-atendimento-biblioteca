## Instruções de operação do ap ##
1. clone o projeto no link URL: https://github.com/victor-delmondes/auto-atendimento-biblioteca.git
2. IDE Preferencial IntelliJ idea 


## Intruções de Configuração do banco de dados H2DB ## 
1. com o app em execução rodando o tomcat7.
2. abra a URL: http://localhost:8080/console
3. usuario: sa
   senha: sa 
4. abra o projeto biblioteca na IDE idea 
5. navegue ate /src/main/resources/DB
6. abra o script.sql e execute-o no console do h2db


## Explicação sobre o banco de dados .

**Tabela Usuarios**

Descrição: Armazena as informações dos usúarios do sistema.

+ **Colunas**

+ ID: Identificador único do usuário(PRIMARY KEY, AUTO_INCREMENT).
+ Nome:Nome completo do usuário
+ E_Mail: Endereço de e-mail.
+ Senha: Senha para autenticação.
+ CPF:Número do CPF do usuário.
+ Endereço,Telefone,Cidade,Estado: Informações de contato e localização.
+ Tipo: Tipo de usúario (Administrador ou cliente).

Essa tabela serve como base para identificar e autenticar os usuários.


**Tabela Livros**

Descrição: Contém os dados sobre os livros disponíveis no sistema.

+ **Colunas**

+ ID: Identificador único do livro (PRIMARY_KEY, AUTO_INCREMENT).
+ Título: Nome do livro.
+ Autor: Autor do livro.
+ Quantidade: Número de exemplares disponíveis.
+ ISBN: Código internacional do livro.
+ Editora: Editora do livro.
+ Ano_publicação: Ano em que o livro foi publicado.
+ Categoria: Categoria ou gênero do livro.
+ Sinopse: Breve descrição ou resumo do livro.
+ Image: Caminho para a imagem da capa do livro.
+ Location: Localização física do livro na biblioteca.

Essa tabela organiza os detalhes dos livros e permite gerenciar o estoque.


**Tabela Emprestimo**

Descrição: Registra os empréstimos de livros realizados pelos usuários.

+ **Colunas**

+ ID_Emprestimo: Identificador único do empréstimo(PRIMARY_KEY, AUTO_INCREMENT).
+ ID_Úsuarios: ID do úsuario que fez o empréstimo.
+ ID_Livro: ID do livro emprestado
+ Data_emprestimo: Data em que o livro foi emprestado.
+ Data_devolucao: Data em que o livro tem que ser devolvido.
+ Status: Estado do empréstimo do livro(pendente,devolvido,atrasado).
+ fk_User_ID: Chave estrangeira relacionada à tabela Usuarios (liga ao campo ID).
+ fk_Livros_ID_Livros: Chave estrangeira relacionada à tabela Livros(liga ao campo ID_Livros).

Exclusão: Quando um usuário ou livro é excluido, os registros associados na tabela Emprestimo também são deletados.







## Instruções de conexão do banco de dados MySQL ##