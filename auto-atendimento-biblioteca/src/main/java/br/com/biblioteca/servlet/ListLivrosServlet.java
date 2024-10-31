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

        LivrosDao livrosDao = new LivrosDao();
        List<Livros> livros;
        List<Livros> categorias = livrosDao.findAllLivros();
        req.setAttribute("categorias", categorias);

        // Obtém a categoria selecionada, se houver
        String categoria = req.getParameter("categoria");

        // Se uma categoria foi selecionada, busca livros dessa categoria, senão busca todos os livros
        if (categoria != null && !categoria.isEmpty()) {
            livros = livrosDao.findLivrosByCategoria(categoria);
        } else {
            livros = livrosDao.findAllLivros();
        }

        req.setAttribute("livros", livros);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
