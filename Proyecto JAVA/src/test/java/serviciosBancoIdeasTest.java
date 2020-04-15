
import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;
import entities.Usuario;
import services.bancoIdeasServices;
import services.bancoIdeasServicesFactory;
import services.ServicesException;
import services.ServiciosUsuario;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class serviciosBancoIdeasTest {

    private bancoIdeasServices bancoIdeas;

    public serviciosBancoIdeasTest() throws ServicesException {
        bancoIdeas = bancoIdeasServicesFactory.getInstance().getIdeasTesting();
    }
    /**
    * Esta prueba utiliza el servicio consultar recurso y verificamos que el objeto que asignamos no este vacio.
    * @throws ServicesException
    */
    @Test
    public void deberiaConsultarUsuario() throws ServicesException {

    Usuario usrPrueba = bancoIdeas.getUsuario("santiago@gmail.com");
    try {
        assertTrue(usrPrueba != null);
        System.out.println(usrPrueba);
    } catch (Exception e) {
        System.out.println(e);
        }
    }

    // @Test
    // public void deberiaFiltrarRecursosPorId() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.recursoPorId(116);

    // assertTrue (recurPrueba !=null);
    // }

    // @Test
    // public void deberiaFiltrarRecursosDisponibles() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.recursosDisponibles();

    // assertTrue (recurPrueba !=null);
    // }

    // @Test
    // public void deberiaFiltrarRecursosPorNombre() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.filtrarNombre("e");

    // //for(Recurso r: recurPrueba) System.out.println(r);

    // assertTrue (recurPrueba !=null);
    // }

    // @Test
    // public void deberiaFiltrarRecursosPorUbicacion() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.filtrarUbicacion("e");

    // //for(Recurso r: recurPrueba) System.out.println(r);

    // assertTrue (recurPrueba !=null);
    // }

    // @Test
    // public void cambiarEstadoMatenimiento() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.recursoPorId(102);

    // boolean testigo = recurPrueba.get(0).isAveriado();

    // bibliotecaS.cambiarEstadoMatenimiento(recurPrueba.get(0).getId());

    // recurPrueba = bibliotecaS.recursoPorId(102);

    // boolean testigo2 = recurPrueba.get(0).isAveriado();


    // assertTrue (testigo != testigo2);
    // }

    // @Test
    // public void deberiaFiltrarRecursosPorCapacidad() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.filtrarCapacidad(5);
    // //for(Recurso r:recurPrueba) System.out.println(r);
    // assertTrue (recurPrueba !=null);
    // }



    // @Test
    // public void deberiaFiltrarRecursosPorTipo() throws ServicesException {

    // List<Recurso> recurPrueba = bibliotecaS.filtrarTipo("l");
    // //for(Recurso r:recurPrueba) System.out.println(r);
    // assertTrue (recurPrueba !=null);
    // }




}