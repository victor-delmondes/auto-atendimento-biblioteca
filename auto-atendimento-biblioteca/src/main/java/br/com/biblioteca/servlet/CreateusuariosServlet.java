package br.com.biblioteca.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-usuario")
public class CreateusuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //super.doPost(request, response);
        String carName = request.getParameter("car-name");

        System.out.println(carName);

        request.getRequestDispatcher("index.html").forward(request, response);

    }
}
