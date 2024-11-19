package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.EmprestimoDao;
import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.model.Emprestimo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/devolucao", "/admin/devolucao"})
public class DevolverEmprestimoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idEmprestimo = req.getParameter("idEmprestimo");
        String status = "Devolvido";

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        Emprestimo emprestimo = new Emprestimo(idEmprestimo, status);
        emprestimoDao.updateEmprestimoStatus(emprestimo);

        String idLivro = emprestimoDao.getIdLivroByIdEmprestimo(idEmprestimo);
        LivrosDao livrosDao = new LivrosDao();
        livrosDao.aumentaQuantidade(idLivro);

        if (req.getServletPath().equals("/devolucao")) {

            resp.sendRedirect("profile.jsp");

        } else if (req.getServletPath().equals("/admin/devolucao")) {

            resp.sendRedirect("/admin/gerenciaremprestimosADM");

        }

    }
}
