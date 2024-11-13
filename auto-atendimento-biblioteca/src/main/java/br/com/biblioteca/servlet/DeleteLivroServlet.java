package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.LivrosDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletelivro")
public class DeleteLivroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        new LivrosDao().deleteLivro(id);

        resp.sendRedirect("/admin/indexADM");

    }
}
