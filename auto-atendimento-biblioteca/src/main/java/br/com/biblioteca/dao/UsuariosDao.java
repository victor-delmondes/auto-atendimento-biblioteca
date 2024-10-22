package br.com.biblioteca.dao;

import br.com.biblioteca.model.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuariosDao {

    public void createUsuario(Usuarios usuario) {

        String SQL = "INSERT INTO USUARIOS (nome,CPF,endereco, telefone, cidade, estado, email, senha) VALUES (?,?,?,?,?,?,?,?)";

        try {
            //Instanciando a conexão com o banco, apontando o caminho , usuario e senha
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("banco conectado com sucesso");//mensagem de conexão bem sucedida

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

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Banco conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuarios> usuarios = new ArrayList<>();

            while (resultSet.next()) {

                String userNome = resultSet.getString("nome");
                String userCPF = resultSet.getString("CPF");
                String userEndereco = resultSet.getString("endereco");
                String userTelefone = resultSet.getString("telefone");
                String userCidade = resultSet.getString("cidade");
                String userEstado = resultSet.getString("estado");
                String userEmail = resultSet.getString("email");
                String userSenha = resultSet.getString("senha");
                int userId = resultSet.getInt("id");
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
    
    public void deleteUsuario(int id) {
        String SQL = "DELETE FROM USUARIOS WHERE id =?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("banco conectado com sucesso");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            System.out.println("Usuario deletado com sucesso");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());
        }
    }
    
    public void updateUsuario(Usuarios usuario){

        String SQL = "UPDATE USUARIOS SET NOME = ?, CPF = ?, ENDERECO = ?, TELEFONE = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, SENHA = ?, TIPO = ? WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Banco conectado com sucesso");

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
            preparedStatement.setInt(10, usuario.getId());
            preparedStatement.execute();

            System.out.println("Usuario atualizado com sucesso");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falha ao Conectar no Banco de dados " + e.getMessage());
        }
    }
}
