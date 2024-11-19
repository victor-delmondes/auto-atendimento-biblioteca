package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.EmprestimoDao;
import br.com.biblioteca.model.Emprestimo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aluguel-confirm")
public class CreateEmprestimoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idLivro = req.getParameter("idLivro");
        String idUsuario = req.getParameter("idUsuario");
        String dataEmprestimo = req.getParameter("dataEmprestimo");
        String dataDevolucao = req.getParameter("dataDevolucao");

        Emprestimo emprestimo = new Emprestimo(idUsuario, idLivro, dataEmprestimo, dataDevolucao, "Em aberto");
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        emprestimoDao.createEmprestimo(emprestimo);

        resp.sendRedirect("scanner.jsp?success=true");
    }
}
