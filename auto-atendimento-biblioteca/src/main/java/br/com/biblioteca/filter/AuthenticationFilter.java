package br.com.biblioteca.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")  // Aplicando filtro para todas as requisições
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);

        String userType = (session != null) ? (String) session.getAttribute("userType") : null;
        String path = httpServletRequest.getRequestURI();

        if (path.startsWith("/admin") && !"admin".equals(userType)) {
            // Redireciona para o login se o usuário não for admin e tentar acessar /admin
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp?error=unauthorized");
        } else {
            // Continua a requisição se o acesso for permitido
            chain.doFilter(servletRequest, response);
        }
    }

    @Override
    public void destroy() {}
}
