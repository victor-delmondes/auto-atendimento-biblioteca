package br.com.biblioteca.dao;

import br.com.biblioteca.model.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class  UsuariosDao {

    public void createUsuario(Usuarios usuario) {

        String SQL = "INSERT INTO USUARIOS (nome,CPF,endereco, telefone, cidade, estado, email, senha) VALUES (?,?,?,?,?,?,?,?)";

        try {
            //Instanciando a conexão com o banco, apontando o caminho , usuario e senha
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

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
            System.out.println("Falha ao Conectar no Banco de dados " +e.getMessage());//Imprimndo mensagem de Falha de Conexão c/ DB
        }
    }
}
