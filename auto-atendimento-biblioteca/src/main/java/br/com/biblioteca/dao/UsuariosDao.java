package br.com.biblioteca.dao;

import br.com.biblioteca.config.ConnectionpoolConfig;
import br.com.biblioteca.model.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuariosDao {

    public String createUsuario(Usuarios usuario) {
        String verificarEmailSQL = "SELECT COUNT(*) AS total FROM USUARIOS WHERE e_mail = ?";
        String inserirUsuarioSQL = "INSERT INTO USUARIOS (nome, CPF, endereco, telefone, cidade, estado, e_mail, senha, tipo) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = ConnectionpoolConfig.getConnection();

            // Verifica se o e-mail já existe
            PreparedStatement verificarStmt = connection.prepareStatement(verificarEmailSQL);
            verificarStmt.setString(1, usuario.getEmail());
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next() && rs.getInt("total") > 0) {
                connection.close();
                return "erro";
            }

            PreparedStatement inserirStmt = connection.prepareStatement(inserirUsuarioSQL);
            inserirStmt.setString(1, usuario.getNome());
            inserirStmt.setString(2, usuario.getCPF());
            inserirStmt.setString(3, usuario.getEndereco());
            inserirStmt.setString(4, usuario.getTelefone());
            inserirStmt.setString(5, usuario.getCidade());
            inserirStmt.setString(6, usuario.getEstado());
            inserirStmt.setString(7, usuario.getEmail());
            inserirStmt.setString(8, usuario.getSenha());
            inserirStmt.setBoolean(9, false);

            inserirStmt.execute();
            connection.close();
            return "sucesso";

        } catch (Exception e) {
            System.out.println("Erro ao conectar no banco: " + e.getMessage());
            return "erro";
        }
    }

    public List<Usuarios> findAllUsers() {

        String SQL = "SELECT * FROM USUARIOS";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuarios> usuarios = new ArrayList<>();

            while (resultSet.next()) {

                String userNome = resultSet.getString("nome");
                String userCPF = resultSet.getString("cpf");
                String userEndereco = resultSet.getString("endereco");
                String userTelefone = resultSet.getString("telefone");
                String userCidade = resultSet.getString("cidade");
                String userEstado = resultSet.getString("estado");
                String userEmail = resultSet.getString("e_mail");
                String userSenha = resultSet.getString("senha");
                String userId = resultSet.getString("id");
                Boolean userTipo = resultSet.getBoolean("tipo");

                Usuarios user = new Usuarios(userNome, userCPF, userEndereco, userTelefone, userCidade, userEstado, userEmail, userSenha, userId, userTipo);

                usuarios.add(user);

            }
            System.out.println("Sucesso no resultado");

            connection.close();

            return usuarios;

        } catch (Exception e) {

            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public List<Usuarios> findUserById(String id) {

        String SQL = "SELECT * FROM USUARIOS WHERE id =?";

        List<Usuarios> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {

            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()){

                while (resultSet.next()) {

                    String userNome = resultSet.getString("nome");
                    String userCPF = resultSet.getString("cpf");
                    String userEndereco = resultSet.getString("endereco");
                    String userTelefone = resultSet.getString("telefone");
                    String userCidade = resultSet.getString("cidade");
                    String userEstado = resultSet.getString("estado");
                    String userEmail = resultSet.getString("e_mail");
                    String userSenha = resultSet.getString("senha");
                    String userId = resultSet.getString("id");
                    Boolean userTipo = resultSet.getBoolean("tipo");

                    Usuarios user = new Usuarios(userNome, userCPF, userEndereco, userTelefone, userCidade, userEstado, userEmail, userSenha, userId, userTipo);

                    usuarios.add(user);

                }

            System.out.println("Sucesso no resultado");

            return usuarios;

            }

        } catch (Exception e) {

            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public void deleteUsuario(String id) {
        String SQL = "DELETE FROM USUARIOS WHERE id =?";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("Usuario deletado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());
        }
    }

    public void updateUsuario(Usuarios usuario) {

        String SQL = "UPDATE USUARIOS SET NOME = ?, CPF = ?, ENDERECO = ?, TELEFONE = ?, CIDADE = ?, ESTADO = ?, E_MAIL = ?, SENHA = ?, TIPO = ? WHERE ID = ?";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCPF());
            preparedStatement.setString(3, usuario.getEndereco());
            preparedStatement.setString(4, usuario.getTelefone());
            preparedStatement.setString(5, usuario.getCidade());
            preparedStatement.setString(6, usuario.getEstado());
            preparedStatement.setString(7, usuario.getEmail());
            preparedStatement.setString(8, usuario.getSenha());
            preparedStatement.setBoolean(9, usuario.getTipo());
            preparedStatement.setString(10, usuario.getId());
            preparedStatement.execute();

            System.out.println(usuario.getNome());
            System.out.println(usuario.getId());
            System.out.println("Usuario atualizado com sucesso");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());
        }
    }

    public Usuarios findUserByEmailAndPassword(String email, String senha) {
        String SQL = "SELECT * FROM USUARIOS WHERE e_mail = ? AND senha = ?";

        try (Connection connection = ConnectionpoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Cria o objeto Usuarios usando o construtor
                Usuarios user = new Usuarios(
                        resultSet.getString("nome"),
                        resultSet.getString("CPF"),
                        resultSet.getString("endereco"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getString("e_mail"),
                        resultSet.getString("senha"),
                        resultSet.getString("id"),
                        resultSet.getBoolean("tipo")
                );
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}