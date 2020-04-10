package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import entities.Usuario;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import persistence.UsuarioDAO;
import persistence.mybatisimpl.MyBatisUsuarioDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
                                                     @Override
                                                     protected void initialize() {

                                                         install(JdbcHelper.MySQL);

                                                         setEnvironmentId("development");

                                                         setClassPathResource("mybatis-config.xml");

                                                         // Blog
                                                         //bind(BlogServices.class).to(BlogServicesImpl.class);
                                                         //bind(BlogDAO.class).to(MyBatisBlogDAO.class);
                                                         // Users
                                                         bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                                                     }
                                                 }

        );

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }
}
