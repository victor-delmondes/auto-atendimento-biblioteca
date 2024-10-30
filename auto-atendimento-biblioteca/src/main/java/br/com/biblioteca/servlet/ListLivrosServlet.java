package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.model.Livros;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"", "/index"})
public class ListLivrosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Livros> livros = new LivrosDao().findAllLivros();

        req.setAttribute("livros", livros);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
