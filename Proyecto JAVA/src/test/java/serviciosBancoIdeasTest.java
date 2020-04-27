import static com.google.inject.Guice.createInjector;

import entities.Iniciativa;
import entities.Usuario;
import exceptions.ServiciosUsuarioException;
import services.ServiciosIniciativa;
import services.bancoIdeasServicesFactory;
import services.ServiciosUsuario;
import exceptions.ServicesException;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.List;

public class serviciosBancoIdeasTest {
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;

    public serviciosBancoIdeasTest() throws ServicesException {
        serviciosUsuario = bancoIdeasServicesFactory.getInstance().getUsuarioTesting();
        serviciosIniciativa = bancoIdeasServicesFactory.getInstance().InsertarIniciativaTesting();

    }

    /**
     * Esta prueba utiliza el servicio consultar recurso y verificamos que el objeto
     * que asignamos no este vacio.
     *
     * @throws ServiciosUsuarioException
     */
    @Test
    public void deberiaConsultarUsuario() throws ServicesException, ServiciosUsuarioException {

        Usuario usrPrueba = serviciosUsuario.consultarUsuario("santiago@gmail.com");
        try {
            assertTrue(usrPrueba != null);
            System.out.println(usrPrueba);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaConsultarUsuarios() throws ServicesException, ServiciosUsuarioException {

        List<Usuario> usrPrueba = serviciosUsuario.consultarUsuarios();
        try {
            assertTrue(usrPrueba != null);
            System.out.println(usrPrueba);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
public void deberiaActualizarUsuarios() throws ServicesException, ServiciosUsuarioException {
    Usuario userpr = new Usuario(8, "laura", "laura@gmail.com", "1234567", "Admin", "Finanzas");
    serviciosUsuario.updateRolUsuario(userpr.getId(), "Admin");
    try {
        Usuario user = serviciosUsuario.consultarUsuario("laura@gmail.com");
        assertTrue("Admin".equals(user.getTipoUser()));
        System.out.println(serviciosUsuario.consultarUsuario("laura@gmail.com"));
    } catch (Exception e) {
        System.out.println(e);
    }
}
//    @Test
//    public void deberiaInsertarUsuarios() throws ServicesException, ServiciosUsuarioException {
//        Usuario userpr = new Usuario(12, "laura", "laura@gmail.com", "1234567", "Admin", "Finanzas");
//
//        serviciosUsuario.insertarUsuario(userpr);
//        try {
//            assertTrue(serviciosUsuario.consultarUsuario("laura@gmail.com") != null);
//            System.out.println(serviciosUsuario.consultarUsuario("laura@gmail.com"));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }


    @Test
    public void deberiaConsultarIniciativas() throws ServicesException, ServiciosUsuarioException {

        List<Iniciativa> iniciativasPrueba = serviciosIniciativa.getIniciativas();
        try {
            assertTrue(iniciativasPrueba != null);
            System.out.println(iniciativasPrueba);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaInsertarIniciativa() throws ServicesException, ServiciosUsuarioException {

        Iniciativa iniciativaPrr = new Iniciativa("pruebaSietesoBien","En espera de revisión",1,"prueba de que funciona","prueba","santi","san@gmail.com");
        serviciosIniciativa.insertIniciativa(iniciativaPrr);
        try {
            assertTrue(serviciosIniciativa.getIniciativas()!=null);
            System.out.println(serviciosIniciativa.getIniciativas());
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
