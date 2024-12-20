package br.com.biblioteca.dao;

import br.com.biblioteca.config.ConnectionpoolConfig;
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
        String SQL = "INSERT INTO livros (titulo, autor, isbn, editora, quantidade, ano_publicacao, sinopse, categoria, image, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionpoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getIsbn());
            preparedStatement.setString(4, livro.getEditora());
            preparedStatement.setString(5, livro.getQuantidade());
            preparedStatement.setString(6, livro.getAnoPublicacao());
            preparedStatement.setString(7, livro.getSinopse());
            preparedStatement.setString(8, livro.getCategoria());
            preparedStatement.setString(9, livro.getImage());
            preparedStatement.setString(10, livro.getLocation());

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
            Connection connection = ConnectionpoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Livros> livros = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id_livros");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String isbn = resultSet.getString("isbn");
                String editora = resultSet.getString("editora");
                String quantidade = resultSet.getString("quantidade");
                String anoPublicacao = resultSet.getString("ano_publicacao");
                String sinopse = resultSet.getString("sinopse");
                String categoria = resultSet.getString("categoria");
                String image = resultSet.getString("image");
                String location = resultSet.getString("location");

                Livros livro = new Livros(titulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);
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
        String SQL = "UPDATE livros SET titulo = ?, autor = ?, isbn = ?, editora = ?, quantidade = ?, ano_publicacao = ?, sinopse = ?, categoria = ?, image = ?, location = ? WHERE id_livros = ?";

        try {
            Connection connection = ConnectionpoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getIsbn());
            preparedStatement.setString(4, livro.getEditora());
            preparedStatement.setString(5, livro.getQuantidade());
            preparedStatement.setString(6, livro.getAnoPublicacao());
            preparedStatement.setString(7, livro.getSinopse());
            preparedStatement.setString(8, livro.getCategoria());
            preparedStatement.setString(9, livro.getImage());
            preparedStatement.setString(10, livro.getLocation());
            preparedStatement.setString(11, livro.getId());

            preparedStatement.executeUpdate();
            System.out.println("Livro atualizado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
    }

    public void deleteLivro(String id) {
        String SQL = "DELETE FROM livros WHERE id_livros = ?";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Livro deletado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
    }

    public List<Livros> findLivrosByCategoria(String categoria) {
        String SQL = "SELECT * FROM livros WHERE categoria = ?";
        List<Livros> livros = new ArrayList<>();

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, categoria);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id_livros");
                    String titulo = resultSet.getString("titulo");
                    String autor = resultSet.getString("autor");
                    String isbn = resultSet.getString("isbn");
                    String editora = resultSet.getString("editora");
                    String quantidade = resultSet.getString("quantidade");
                    String anoPublicacao = resultSet.getString("ano_publicacao");
                    String sinopse = resultSet.getString("sinopse");
                    String image = resultSet.getString("image");
                    String location = resultSet.getString("location");

                    Livros livro = new Livros(titulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);
                    livros.add(livro);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
        return livros;
    }

    public List<Livros> findLivrosByTitulo(String titulo) {
        String SQL = "SELECT * FROM livros WHERE " +
                "LOWER(TRANSLATE(titulo, 'áéíóúãõâêîôûç', 'aeiouaoaeiouc')) LIKE " +
                "LOWER(TRANSLATE(?, 'áéíóúãõâêîôûç', 'aeiouaoaeiouc'))";
        List<Livros> livros = new ArrayList<>();

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, "%" + titulo.toLowerCase() + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String BookTitulo = resultSet.getString("titulo");
                    String id = resultSet.getString("id_livros");
                    String categoria = resultSet.getString("categoria");
                    String autor = resultSet.getString("autor");
                    String isbn = resultSet.getString("isbn");
                    String editora = resultSet.getString("editora");
                    String quantidade = resultSet.getString("quantidade");
                    String anoPublicacao = resultSet.getString("ano_publicacao");
                    String sinopse = resultSet.getString("sinopse");
                    String image = resultSet.getString("image");
                    String location = resultSet.getString("location");

                    Livros livro = new Livros(BookTitulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);
                    livros.add(livro);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
        return livros;
    }

    public List<Livros> findLivrosByCode(String code) {

        String SQL = "SELECT * FROM LIVROS WHERE ISBN = ?";

        List<Livros> livros = new ArrayList<>();

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, code);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String Titulo = resultSet.getString("titulo");
                    String id = resultSet.getString("id_livros");
                    String categoria = resultSet.getString("categoria");
                    String autor = resultSet.getString("autor");
                    String isbn = resultSet.getString("isbn");
                    String editora = resultSet.getString("editora");
                    String quantidade = resultSet.getString("quantidade");
                    String anoPublicacao = resultSet.getString("ano_publicacao");
                    String sinopse = resultSet.getString("sinopse");
                    String image = resultSet.getString("image");
                    String location = resultSet.getString("location");

                    Livros livro = new Livros(Titulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);
                    livros.add(livro);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
        return livros;

    }

    public List<Livros> findLivrosById(String livroId){

        String SQL = "SELECT * FROM LIVROS WHERE id_livros =?";

        List<Livros> livros = new ArrayList<>();

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, livroId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String Titulo = resultSet.getString("titulo");
                    String id = resultSet.getString("id_livros");
                    String categoria = resultSet.getString("categoria");
                    String autor = resultSet.getString("autor");
                    String isbn = resultSet.getString("isbn");
                    String editora = resultSet.getString("editora");
                    String quantidade = resultSet.getString("quantidade");
                    String anoPublicacao = resultSet.getString("ano_publicacao");
                    String sinopse = resultSet.getString("sinopse");
                    String image = resultSet.getString("image");
                    String location = resultSet.getString("location");

                    Livros livro = new Livros(Titulo, autor, isbn, editora, quantidade, anoPublicacao, id, sinopse, categoria, image, location);
                    livros.add(livro);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());
        }
        return livros;

    }

    public void aumentaQuantidade(String id) {

        String SQL = "UPDATE livros SET quantidade = quantidade + 1 WHERE id_livros = ?";

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Quantidade do livro aumentada com sucesso");

        } catch (Exception e) {

            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());

        }

    }

    public void diminuiQuantidade(String id) {

        String SQL = "UPDATE livros SET quantidade = quantidade + 1 WHERE id_livros = ?";

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Quantidade do livro subtraida com sucesso");

        } catch (Exception e) {

            System.out.println("Falha ao conectar no banco de dados " + e.getMessage());

        }

    }

}

