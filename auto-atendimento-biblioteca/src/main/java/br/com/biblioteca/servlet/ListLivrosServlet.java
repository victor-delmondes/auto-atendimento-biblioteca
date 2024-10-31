package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.model.Livros;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet({"", "/index"})
public class ListLivrosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LivrosDao livrosDao = new LivrosDao();
        List<Livros> livros;
        List<Livros> todasCategorias = livrosDao.findAllLivros();
        Set<String> categorias = todasCategorias.stream()
                .map(Livros::getCategoria) // Pega apenas o campo de categoria
                .collect(Collectors.toSet()); // Usa um Set para remover duplicados
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
