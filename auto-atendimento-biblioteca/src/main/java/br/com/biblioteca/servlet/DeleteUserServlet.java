package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.UsuariosDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idUser = req.getParameter("id");

        new UsuariosDao().deleteUsuario(idUser);

        resp.sendRedirect("/admin/gerenciarusersADM");

    }
}
