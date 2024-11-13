package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.UsuariosDao;
import br.com.biblioteca.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuarios usuarios = new Usuarios(email, senha);

        boolean isValidUser = new UsuariosDao().verificaCredencial(usuarios);

        if (isValidUser) {

            request.getSession().setAttribute("loggedUser", email);

            response.sendRedirect("/index");

        } else {

            request.setAttribute("message", "Credenciais inválidas!");

            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

    }

}
