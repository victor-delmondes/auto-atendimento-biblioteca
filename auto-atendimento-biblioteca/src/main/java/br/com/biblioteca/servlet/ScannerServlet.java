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

@WebServlet("/scanner")
public class ScannerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("codigo");

        LivrosDao livrosDao = new LivrosDao();

        List<Livros> livros = livrosDao.findLivrosByCode(code);

        if (livros.isEmpty()) {
            resp.sendRedirect("scanner.jsp?error=notfound");
        } else {
            req.setAttribute("livro", livros.get(0));
            req.getRequestDispatcher("alugar.jsp").forward(req, resp);
        }
    }
}
