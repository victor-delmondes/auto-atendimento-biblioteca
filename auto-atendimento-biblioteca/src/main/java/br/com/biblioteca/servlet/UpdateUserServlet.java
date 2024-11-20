package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.UsuariosDao;
import br.com.biblioteca.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/update-user", "/update-users"})
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("nome");
        String userEmail = req.getParameter("email");
        String userId = req.getParameter("userid");
        String userSenha = req.getParameter("senha");
        String userTelefone = req.getParameter("telefone");
        String userEndereco = req.getParameter("endereco");
        String userCPF = req.getParameter("cpf");
        String userCidade = req.getParameter("cidade");
        String userEstado = req.getParameter("estado");
        boolean userTipo = Boolean.parseBoolean(req.getParameter("tipo"));

        UsuariosDao usuariosDao = new UsuariosDao();
        Usuarios usuarios = new Usuarios(userName, userCPF, userEndereco, userTelefone, userCidade, userEstado, userEmail, userSenha, userId, userTipo);

        usuariosDao.updateUsuario(usuarios);

        // Verifica qual caminho foi chamado
        String path = req.getServletPath();

        if ("/update-users".equals(path)) {
            resp.sendRedirect("/admin/gerenciarusersADM");
        } else if ("/update-user".equals(path)) {
            // Redireciona com base no tipo de usuário
            if (userTipo) {
                resp.sendRedirect("/admin/confADM.jsp?success=true");
            } else {
                resp.sendRedirect("/profile");
            }
        }
    }
}


