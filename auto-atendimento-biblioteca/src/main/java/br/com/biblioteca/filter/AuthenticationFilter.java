package br.com.biblioteca.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if(isUserLoggedOn(httpServletRequest)) {

            chain.doFilter(servletRequest, response);

        } else {

            servletRequest.setAttribute("message", "Usuário não autenticado!");

            servletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);

        }

    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedOn(HttpServletRequest httpServletRequest) {

        return httpServletRequest.getSession().getAttribute("loggedUser")!= null;

    }

}
