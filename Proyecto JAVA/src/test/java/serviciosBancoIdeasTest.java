import static com.google.inject.Guice.createInjector;
import entities.Usuario;
import exceptions.ServiciosUsuarioException;
import services.bancoIdeasServicesFactory;
import services.ServicesException;
import services.ServiciosUsuario;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.List;

public class serviciosBancoIdeasTest {

    private ServiciosUsuario serviciosUsuario;

    public serviciosBancoIdeasTest() throws ServicesException {
        serviciosUsuario = bancoIdeasServicesFactory.getInstance().getUsuarioTesting();
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
    public void deberiaInsertarUsuarios() throws ServicesException, ServiciosUsuarioException {
        Usuario userpr = new Usuario(12, "laura", "laura@gamil.com", "1234567", "Admin", "Solucionado");

        serviciosUsuario.insertarUsuario(userpr);
        try {
            assertTrue(serviciosUsuario.consultarUsuario("laura@gamil.com") != null);
            System.out.println(serviciosUsuario.consultarUsuario("laura@gamil.com"));
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