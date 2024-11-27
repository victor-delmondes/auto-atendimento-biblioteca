package br.com.biblioteca.servlet;// Define o pacote onde esta classe está localizada.

// Importa as bibliotecas necessárias para trabalhar com Servlets, exceções e operações de I/O.

import br.com.biblioteca.dao.UsuariosDao;
import br.com.biblioteca.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")// Anota a classe para que ela seja acessível via URL "/register".
public class CreateusuariosServlet extends HttpServlet { // Define uma classe pública que herda de HttpServlet, permitindo que ela trate requisições HTTP.

    @Override // Sobrescreve o metodo doPost para tratar requisições POST.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //super.doPost(request, response);// Linha que chama a implementação original do método doPost.

        //Instanciando as classes
        Usuarios usuario = new Usuarios();//instanciando a classe Usuarios
        UsuariosDao usuarioDao = new UsuariosDao();//Instanciando a classe UsuariosDao

        //todas as entradas(inputs) da pagina register aqui
        String nome = request.getParameter("nome");// Recebe o parâmetro "nome" do input da página "cadastro-usuario".
        usuario.setNome(nome);//chamando a função nome
        System.out.println("nome usuario " + nome); // Imprime no console o valor do parâmetro "nome".

        String CPF = request.getParameter("cpf");// Recebe o parâmetro "CPF" do input da página "cadastro-usuario".
        usuario.setCPF(CPF);
        System.out.println("CPF usuario " + CPF);// Imprime no console o valor do parâmetro "CPF".

        String endereco = request.getParameter("endereco");// Recebe o parâmetro "endereco" do input da página "cadastro-usuario".
        usuario.setEndereco(endereco);
        System.out.println("Endereço Usuario " + endereco);// Imprime no console o valor do parâmetro "endereco".

        String telefone = request.getParameter("telefone");// Recebe o parâmetro "telefone" do input da página "cadastro-usuario".
        usuario.setTelefone(telefone);
        System.out.println("Telefone Usuario " + telefone);// Imprime no console o valor do parâmetro "telefone".

        String cidade = request.getParameter("cidade");// Recebe o parâmetro "cidade" do input da página "cadastro-usuario".
        usuario.setCidade(cidade);
        System.out.println("Cidade Usuario " + cidade);// Imprime no console o valor do parâmetro "cidade".

        String estado = request.getParameter("estado");// Recebe o parâmetro "estado" do input da página "cadastro-usuario".
        usuario.setEstado(estado);
        System.out.println("Estado usuario " + estado);// Imprime no console o valor do parâmetro "estado".

        String email = request.getParameter("email");// Recebe o parâmetro "email" do input da página "cadastro-usuario".
        usuario.setEmail(email);
        System.out.println("Email Usuario " + email);// Imprime no console o valor do parâmetro "email".

        String senha = request.getParameter("senha");// Recebe o parâmetro "senha" do input da página "cadastro-usuario".
        usuario.setSenha(senha);
        System.out.println("Senha Usuario " + senha);// Imprime no console o valor do parâmetro "senha".


        String resultado = usuarioDao.createUsuario(usuario);

        if (resultado.equals("sucesso")) {
            request.setAttribute("status", "sucesso");
        } else {
            request.setAttribute("status", "erro");
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);// Encaminha a requisição e resposta para a página "register.jsp".

    }
}
