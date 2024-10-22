package br.com.biblioteca.dao;

import br.com.biblioteca.model.Livros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivrosDao {

    public void createLivro(Livros livro) {
        String SQL = "INSERT INTO livros (titulo, autor, isbn, editora, quantidade, ano_publicacao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getIsbn());
            preparedStatement.setString(4, livro.getEditora());
            preparedStatement.setInt(5, livro.getQuantidade());
            preparedStatement.setInt(6, livro.getAnoPublicacao());

            preparedStatement.execute();
            System.out.println("Livro criado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
    }

    public List<Livros> findAllLivros() {
        String SQL = "SELECT * FROM livros";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Livros> livros = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_livros");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String isbn = resultSet.getString("isbn");
                String editora = resultSet.getString("editora");
                int quantidade = resultSet.getInt("quantidade");
                int anoPublicacao = resultSet.getInt("ano_publicacao");

                Livros livro = new Livros(titulo, autor, isbn, editora, quantidade, anoPublicacao, id);
                livros.add(livro);
            }

            connection.close();

            return livros;

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void updateLivro(Livros livro) {
        String SQL = "UPDATE livros SET titulo = ?, autor = ?, isbn = ?, editora = ?, quantidade = ?, ano_publicacao = ? WHERE id_livros = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getIsbn());
            preparedStatement.setString(4, livro.getEditora());
            preparedStatement.setInt(5, livro.getQuantidade());
            preparedStatement.setInt(6, livro.getAnoPublicacao());
            preparedStatement.setInt(7, livro.getId());

            preparedStatement.executeUpdate();
            System.out.println("Livro atualizado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
    }

    public void deleteLivro(int id) {
        String SQL = "DELETE FROM livros WHERE id_livros = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Livro deletado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
    }
}
