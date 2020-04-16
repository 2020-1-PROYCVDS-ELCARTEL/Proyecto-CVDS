package services;

import com.google.inject.Guice;
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
        bancoInjector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("bd-config.xml");
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);

                //bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
        });
        testInjector = Guice.createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("bd-config.xml");
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);

                //bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(BlogDAO.class).to(MyBatisBlogDAO.class);
            }
        });

    }

    public ServiciosUsuario getIdeas(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario getIdeasTesting(){
        return testInjector.getInstance(ServiciosUsuario.class);
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
