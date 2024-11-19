package br.com.biblioteca.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Configuração da conexão com o banco de dados H2
            String url = "jdbc:h2:~/test";
            String user = "sa";
            String password = "sa";

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            boolean tablesExist = false;
            try {
                // Verifica se a tabela "Usuarios" existe tentando uma consulta simples
                ResultSet resultSet = statement.executeQuery("SELECT 1 FROM Usuarios LIMIT 1");
                tablesExist = resultSet.next();
                resultSet.close();
            } catch (Exception e) {
                // Exceção indica que a tabela não existe, então podemos criá-la
                tablesExist = false;
            }

            if (!tablesExist) {
                // Script de criação das tabelas
                String sql = "CREATE TABLE Usuarios (" +
                        "ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "Nome VARCHAR(100), " +
                        "E_Mail VARCHAR(100), " +
                        "Senha VARCHAR(100), " +
                        "CPF VARCHAR(11), " +
                        "Endereco VARCHAR(200), " +
                        "Telefone VARCHAR(15), " +
                        "Cidade VARCHAR(100), " +
                        "Estado VARCHAR(2), " +
                        "Tipo BOOLEAN" +
                        "); " +
                        "CREATE TABLE Livros (" +
                        "ID_Livros INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "Titulo VARCHAR(200), " +
                        "Autor VARCHAR(100), " +
                        "Quantidade INTEGER, " +
                        "ISBN VARCHAR(13), " +
                        "Editora VARCHAR(100), " +
                        "Ano_publicacao INTEGER, " +
                        "Categoria VARCHAR(100), " +
                        "Sinopse VARCHAR(20000), " +
                        "Image VARCHAR(300), " +
                        "location VARCHAR(200)" +
                        "); " +
                        "CREATE TABLE Emprestimo (" +
                        "ID_Emprestimo INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "ID_Usuarios INTEGER, " +
                        "ID_Livro INTEGER, " +
                        "Data_emprestimo DATE, " +
                        "Data_devolucao DATE, " +
                        "Status VARCHAR(50), " +
                        "FOREIGN KEY (ID_Usuarios) REFERENCES Usuarios(ID) ON DELETE CASCADE, " +
                        "FOREIGN KEY (ID_Livro) REFERENCES Livros(ID_Livros) ON DELETE CASCADE" +
                        "); " +
                        "CREATE TABLE ListaDesejos (" +
                        "ID_ListaDesejos INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "ID_User INTEGER, " +
                        "ID_Livro INTEGER, " +
                        "fk_User_ID INTEGER, " +
                        "fk_Livros_ID_Livros INTEGER, " +
                        "FOREIGN KEY (ID_User) REFERENCES Usuarios(ID) ON DELETE CASCADE, " +
                        "FOREIGN KEY (ID_Livro) REFERENCES Livros(ID_Livros) ON DELETE CASCADE" +
                        ");";



                statement.executeUpdate(sql);

                // Insere o usuário "admin" na tabela "Usuarios"
                String insertAdmin = "INSERT INTO Usuarios (Nome, E_Mail, Senha, CPF, Endereco, Telefone, Cidade, Estado, Tipo) "
                        + "VALUES ('Admin', 'admin@admin.com', 'admin', '00000000000', '', '', '', '', TRUE);";
                statement.executeUpdate(insertAdmin);

                System.out.println("Tabelas criadas e usuário admin inserido.");
            } else {
                System.out.println("As tabelas já existem, não é necessário criar o usuário admin.");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Código opcional ao encerrar a aplicação
    }
}
