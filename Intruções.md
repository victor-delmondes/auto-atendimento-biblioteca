## Instruções de operação do ap ##
1. clone o projeto no link URL: https://github.com/victor-delmondes/auto-atendimento-biblioteca.git
2. IDE Preferencial IntelliJ idea 


## Intruções de Configuração do banco de dados H2DB ## 
OBS: O aplicativo ja cria automaticamente as tabelas do banco de dados com uma conta de administrador padrão: email "admin@admin.com" e senha "admin"
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
+ FOREIGN KEY (ID_Usuarios): Define que a coluna ID_Usuarios da tabela Emprestimo esta vinculada à coluna ID da tabela Usuarios.
+ FOREIGN KEY (ID_Livros): Define que a coluna ID_Livros da tabela Emprestimo está vinculada à coluna ID_Livros da tabela Livros.

**Exclusão** ON DELETE CASCADE: Garante que ao excluir um registro na tabela pai (Usuarios ou Livros), os registros relacionados na tabela Emprestimo sejam automaticamente removidos.


**Tabela ListaDesejos**

Descrição: Permite que os úsuarios adicionem livros de interesse em uma lista de desejos.

+ **Colunas**

+ ID_ListaDesejos: Identificador único da lista (PRIMARY_KEY, AUTO_INCREMENT).
+ ID_User: ID do úsuario associado a lista
+ ID_Livro: ID do livro incluido  na lista de desejos.
+ FOREIGN KEY (ID_User): Relaciona a coluna ID_User da tabela ListaDesejos à coluna ID da tabela Usuarios.
+ FOREIGN KEY (ID_Livro): Relaciona a coluna ID_Livro da tabela ListaDesejos à coluna ID_Livros da tabela Livros.

**Exclusão** ON DELETE CASCADE: Garante que ao excluir um registro em Usuarios ou Livros, os registros relacionados  na tabela ListaDesejos sejam automaticamente removidos.


## Instruções de conexão do banco de dados MySQL ##
