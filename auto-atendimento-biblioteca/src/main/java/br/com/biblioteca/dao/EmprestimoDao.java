package br.com.biblioteca.dao;

import br.com.biblioteca.config.ConnectionpoolConfig;
import br.com.biblioteca.model.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmprestimoDao {

    public void createEmprestimo(Emprestimo emprestimo) {

        String SQL = "INSERT INTO EMPRESTIMO (ID_USUARIOS, ID_LIVRO, DATA_EMPRESTIMO, DATA_DEVOLUCAO, STATUS) VALUES (?, ? , ? , ?, ?)";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, emprestimo.getIdUsuarios());
            preparedStatement.setString(2, emprestimo.getIdLivro());
            preparedStatement.setString(3, emprestimo.getDataEmprestimo());
            preparedStatement.setString(4, emprestimo.getDataDevolucao());
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

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Emprestimo> emprestimos = new ArrayList<>();

            while (resultSet.next()) {

                String emprestimoId = resultSet.getString("id_emprestimo");
                String usuarioId = resultSet.getString("id_usuarios");
                String livroId = resultSet.getString("id_livros");
                String dataEmprestimo = resultSet.getString("data_emprestimo");
                String dataDevolucao = resultSet.getString("data_devolucao");
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

    public void deleteEmprestimo(String id) {

        String SQL = "DELETE FROM EMPRESTIMO WHERE id_emprestimo =?";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

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

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, emprestimo.getIdUsuarios());
            preparedStatement.setString(2, emprestimo.getIdLivro());
            preparedStatement.setString(3, emprestimo.getDataEmprestimo());
            preparedStatement.setString(4, emprestimo.getDataDevolucao());
            preparedStatement.setString(5, emprestimo.getStatus());
            preparedStatement.setString(6, emprestimo.getIdEmprestimo());

            preparedStatement.execute();

            System.out.println("Empréstimo atualizado com sucesso!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados: " + e.getMessage());
        }
    }

    public String getIdLivroByIdEmprestimo(String idEmprestimo) {

        String SQL = "SELECT id_livro FROM EMPRESTIMO WHERE id_emprestimo = ?";

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, idEmprestimo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("id_livro");
            } else {
                throw new RuntimeException("Nenhum empréstimo encontrado com o ID: " + idEmprestimo);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o ID do livro: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar o ID do livro", e);
        }
    }


}