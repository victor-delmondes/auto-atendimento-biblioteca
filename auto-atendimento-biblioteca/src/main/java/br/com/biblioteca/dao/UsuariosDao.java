package br.com.biblioteca.dao;

import br.com.biblioteca.config.ConnectionpoolConfig;
import br.com.biblioteca.model.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuariosDao {

    public void createUsuario(Usuarios usuario) {

        String SQL = "INSERT INTO USUARIOS (nome,CPF,endereco, telefone, cidade, estado, e_mail, senha, tipo) VALUES (?,?,?,?,?,?,?,?, ?)";

        try {

            Connection connection = ConnectionpoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            //Recebendo os parametros da Classe Usuarios , p/ gravar no DB
            preparedStatement.setString(1, usuario.getNome());//Recebendo o parametro 1 nome da classe Usuarios
            preparedStatement.setString(2, usuario.getCPF());//recebendo o parametro CPF
            preparedStatement.setString(3, usuario.getEndereco());//Recebendo os parametros Endereço
            preparedStatement.setString(4, usuario.getTelefone());//recebendo os parametros Telefone
            preparedStatement.setString(5, usuario.getCidade());//Recebendo os parametros cidade
            preparedStatement.setString(6, usuario.getEstado());//Recebendo os parametros estado
            preparedStatement.setString(7, usuario.getEmail());//Recebendo os parametros email
            preparedStatement.setString(8, usuario.getSenha());//Recebendo os parametros senha
            preparedStatement.setBoolean(9, false);

            preparedStatement.execute();//Executando o envio para o banco
            System.out.println("Sucesso em Inserir os dados no DB ");

            connection.close();//Fechando a conexão com o DB

        } catch (Exception e) {
            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());//Imprimndo mensagem de Falha de Conexão c/ DB
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