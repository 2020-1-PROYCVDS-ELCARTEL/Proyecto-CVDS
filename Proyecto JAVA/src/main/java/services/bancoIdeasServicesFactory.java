package services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import persistence.UsuarioDAO;
import persistence.mybatisimpl.MyBatisUsuarioDAO;
import services.impl.ServiciosUsuarioImpl;

public class bancoIdeasServicesFactory {

    private static bancoIdeasServicesFactory instance = new bancoIdeasServicesFactory();

    private static Injector bancoInjector;
    private static Injector testInjector;

    private bancoIdeasServicesFactory(){
        bancoInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("bd-config.xml");

                //bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
        });
        testInjector = createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("bd-config.xml");

                //bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
        });

    }

    public bancoIdeasServices getIdeas(){
        return bancoInjector.getInstance(bancoIdeasServices.class);
    }
    public bancoIdeasServices getIdeasTesting(){
        return testInjector.getInstance(bancoIdeasServices.class);
    }

    //     return optInjector.get().getInstance(BlogServices.class);
    // }


    // public BlogServices getBlogServicesTesting(){
    //     if (!optInjector.isPresent()) {
    //         optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml", JdbcHelper.H2_FILE));
    //     }

    //     return optInjector.get().getInstance(BlogServices.class);
    // }



    public static bancoIdeasServicesFactory getInstance(){
        return instance;
    }

}
