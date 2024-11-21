package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.EmprestimoDao;
import br.com.biblioteca.dao.LivrosDao;
import br.com.biblioteca.dao.UsuariosDao;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livros;
import br.com.biblioteca.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/gerenciaremprestimosADM")
public class ListEmprestimosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Emprestimo> emprestimos = new EmprestimoDao().findAllEmprestimos();

        Map<Emprestimo, Map<String, String>> emprestimosComDetalhes = new HashMap<>();
        LivrosDao livrosDao = new LivrosDao();
        UsuariosDao usuariosDao = new UsuariosDao();

        for (Emprestimo emprestimo : emprestimos) {

            String livroId = emprestimo.getIdLivro();
            String userID = emprestimo.getIdUsuarios();

            List<Usuarios> usuariosEncontrados = usuariosDao.findUserById(userID);
            List<Livros> livrosEncontrados = livrosDao.findLivrosById(livroId);

            String livroTitulo = livrosEncontrados.get(0).getTitulo();
            String usuarioNome = usuariosEncontrados.get(0).getNome();

            Map<String, String> detalhes = new HashMap<>();
            detalhes.put("livroTitulo", livroTitulo);
            detalhes.put("usuarioNome", usuarioNome);

            emprestimosComDetalhes.put(emprestimo, detalhes);
        }

        req.setAttribute("emprestimosComDetalhes", emprestimosComDetalhes);

        req.getRequestDispatcher("gerenciaremprestimosADM.jsp").forward(req, resp);

    }
}
