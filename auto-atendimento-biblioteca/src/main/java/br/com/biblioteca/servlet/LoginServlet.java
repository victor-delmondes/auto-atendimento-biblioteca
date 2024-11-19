package br.com.biblioteca.servlet;

import br.com.biblioteca.dao.UsuariosDao;
import br.com.biblioteca.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuariosDao usuariosDao = new UsuariosDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuarios user = usuariosDao.findUserByEmailAndPassword(email, senha);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (user.getTipo()) {  // Verifica se o usuário é administrador
                session.setAttribute("userType", "admin");
                response.sendRedirect(request.getContextPath() + "/admin/indexADM");
            } else {
                session.setAttribute("userType", "user");
                response.sendRedirect(request.getContextPath() + "/index");
            }
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
