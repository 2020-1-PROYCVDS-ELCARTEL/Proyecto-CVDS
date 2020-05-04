package services;

import com.google.inject.Guice;
import java.util.Optional;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Injector;

import persistence.ComentarioDAO;
import persistence.IniciativaDAO;
import persistence.UsuarioDAO;
import persistence.VotoDAO;
import persistence.mybatisimpl.MyBatisComentarioDAO;
import persistence.mybatisimpl.MyBatisIniciativaDAO;
import persistence.mybatisimpl.MyBatisUsuarioDAO;
import persistence.mybatisimpl.MyBatisVotoDAO;
import services.impl.ServiciosIniciativaImpl;
import services.impl.ServiciosUsuarioImpl;
import services.impl.ServiciosVotoImpl;

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
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
                bind(ComentarioDAO.class).to(MyBatisComentarioDAO.class);

                //bind(VotoDAO.class).to(MyBatisVotoDAO.class);

                bind(ServiciosIniciativa.class).to(ServiciosIniciativaImpl.class);
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);

                //bind(ServiciosVoto.class).to(ServiciosVotoImpl.class);
            }
        });
        testInjector = Guice.createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("bd-config.xml");
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
                bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
                bind(ServiciosIniciativa.class).to(ServiciosIniciativaImpl.class);
                //bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(BlogDAO.class).to(MyBatisBlogDAO.class);

            }
        });

    }

    public ServiciosUsuario getUsuario(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario getUsuarios(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario insertUsuario(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario updateRolUsuario(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosIniciativa InsertarIniciativa(){
        return bancoInjector.getInstance(ServiciosIniciativa.class);
    }
    public ServiciosIniciativa getIniciativas(){
        return bancoInjector.getInstance(ServiciosIniciativa.class);
    }
    /*public ServiciosVoto getVoto(){
        return bancoInjector.getInstance(ServiciosVoto.class);
    }
    public ServiciosVoto insertVoto(){
        return bancoInjector.getInstance(ServiciosVoto.class);
    }
    public ServiciosVoto deleteVoto(){
        return bancoInjector.getInstance(ServiciosVoto.class);
    }*/
    public ServiciosUsuario insertUsuarioTesting(){
        return bancoInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario getUsuariosTesting(){
        return testInjector.getInstance(ServiciosUsuario.class);
    }
    public ServiciosUsuario getUsuarioTesting(){
        return testInjector.getInstance(ServiciosUsuario.class);
    }

    public ServiciosIniciativa InsertarIniciativaTesting(){
        return testInjector.getInstance(ServiciosIniciativa.class);
    }
    public ServiciosIniciativa getIniciativasTesting(){
        return testInjector.getInstance(ServiciosIniciativa.class);
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
