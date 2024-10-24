package br.com.biblioteca.dao;

import br.com.biblioteca.model.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmprestimoDao {

    public void createEmprestimo(Emprestimo emprestimo) {

        String SQL = "INSERT INTO EMPRESTIMO (ID_USUARIOS, ID_LIVROS, DATA_EMPRESTIMO, DATA_DEVOLUCAO, STATUS) VALUES (?, ? , ? , ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, emprestimo.getIdUsuarios());
            preparedStatement.setInt(2, emprestimo.getIdLivro());
            preparedStatement.setDate(3, emprestimo.getDataEmprestimo());
            preparedStatement.setDate(4, emprestimo.getDataDevolucao());

            preparedStatement.setString(5, emprestimo.getStatus());

            preparedStatement.execute();

            System.out.println("Empréstimo adicionado com sucesso!");

            connection.close();

        } catch (SQLException e) {

            System.out.println("Falha ao conectar ao banco de dados: " + e.getMessage());
        }

    }

    public List<Emprestimo> findAllEmprestimos() {

        String SQL = "SELECT * FROM EMPRESTIMO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Emprestimo> emprestimos = new ArrayList<>();

            while (resultSet.next()) {

                int emprestimoId = resultSet.getInt("id_emprestimo");
                int usuarioId = resultSet.getInt("id_usuarios");
                int livroId = resultSet.getInt("id_livros");
                Date dataEmprestimo = resultSet.getDate("data_emprestimo");
                Date dataDevolucao = resultSet.getDate("data_devolucao");
                String status = resultSet.getString("status");

                Emprestimo emprestimo = new Emprestimo(emprestimoId, usuarioId, livroId, dataEmprestimo, dataDevolucao, status);

                emprestimos.add(emprestimo);

            }

            System.out.println("Sucesso no resultado");

            connection.close();

            return emprestimos;

        } catch (Exception e) {

            System.out.println("Falha ao buscar empréstimos: " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public void deleteEmprestimo(int id) {

        String SQL = "DELETE FROM EMPRESTIMO WHERE id_emprestimo =?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("banco conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            System.out.println("Empréstimo deletado com sucesso");

            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de daods" + e.getMessage());
        }
    }

    public void updateEmprestimo(Emprestimo emprestimo) {

        String SQL = "UPDATE EMPRESTIMO SET ID_USUARIOS =?, ID_LIVROS =?, DATA_EMPRESTIMO =?, DATA_DEVOLUCAO =?, STATUS =? WHERE ID_EMPRESTIMO =?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Banco de dados conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, emprestimo.getIdUsuarios());
            preparedStatement.setInt(2, emprestimo.getIdLivro());
            preparedStatement.setDate(3, emprestimo.getDataEmprestimo());
            preparedStatement.setDate(4, emprestimo.getDataDevolucao());
            preparedStatement.setString(5, emprestimo.getStatus());
            preparedStatement.setInt(6, emprestimo.getIdEmprestimo());

            preparedStatement.execute();

            System.out.println("Empréstimo atualizado com sucesso!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados: " + e.getMessage());
        }
    }

}