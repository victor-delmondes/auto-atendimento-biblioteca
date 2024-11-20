package br.com.biblioteca.config;

import br.com.biblioteca.dao.EmprestimoDao;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AtualizarEmprestimos implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Executado quando o servidor inicia
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        emprestimoDao.atualizarEmprestimosAtrasados();
        System.out.println("Status dos empréstimos atualizados com sucesso ao iniciar o sistema.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Sem lógica ao desligar o servidor
    }

}
