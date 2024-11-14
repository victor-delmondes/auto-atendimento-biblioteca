package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.model.Livros;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet({"", "/index", "/admin/indexADM"})
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
        // Obtém a pesquisa, se houver
        String pesquisa = req.getParameter("pesquisa");

        // Se uma categoria foi selecionada, busca livros dessa categoria, senão busca todos os livros
        if (categoria != null && !categoria.isEmpty()) {
            livros = livrosDao.findLivrosByCategoria(categoria);
        }
        // Se uma pesquisa foi feita, busca livros com esse título, senão busca todos os livros
        else if (pesquisa != null && !pesquisa.isEmpty()){
            livros = livrosDao.findLivrosByTitulo(pesquisa);
        }

        else {
            livros = livrosDao.findAllLivros();
        }

        req.setAttribute("livros", livros);

        // Verifica o tipo de usuário para redirecionamento
        HttpSession session = req.getSession(false);
        String userType = (session != null) ? (String) session.getAttribute("userType") : "user"; // Assume "user" se não estiver logado

        // Redireciona para a página apropriada com base no tipo de usuário
        if ("admin".equals(userType)) {
            req.getRequestDispatcher("/admin/indexADM.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}