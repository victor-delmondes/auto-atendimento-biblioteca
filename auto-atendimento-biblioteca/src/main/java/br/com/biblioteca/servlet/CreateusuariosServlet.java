package br.com.biblioteca.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro-usuario")
public class CreateusuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //super.doPost(request, response);
        String nameUsuario = request.getParameter("nameUsuario");//recebendo nomeUsuario do input da pagina cadastro-usuario
        System.out.println("nome usuario " +nameUsuario); //Imprimindo a variavel nomeUsuario

        String CPF = request.getParameter("CPF");//recebendo cpf do input da pagina cadastro-usuario
        System.out.println("CPF usuario "+CPF);//Imprimindo a variavel CPF

        String endereco = request.getParameter("endereco");
        System.out.println("Endereço Usuario "+endereco);

        String telefone = request.getParameter("telefone");
        System.out.println("Telefone Usuario "+telefone);

        String cidade = request.getParameter("cidade");
        System.out.println("Cidade Usuario "+cidade);

        String estado = request.getParameter("estado");
        System.out.println("Estado usuario "+estado);

        String email = request.getParameter("email");
        System.out.println("Email Usuario "+email);

        String senha = request.getParameter("senha");
        System.out.println("Senha Usuario "+senha);

        request.getRequestDispatcher("cadastro-usuario.html").forward(request, response);

    }
}
