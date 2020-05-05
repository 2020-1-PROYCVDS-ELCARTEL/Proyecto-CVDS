import entities.Iniciativa;
import entities.Usuario;
import exceptions.ServicesException;
import exceptions.ServiciosUsuarioException;
import org.junit.Test;
import services.ServiciosIniciativa;
import services.ServiciosUsuario;
import services.bancoIdeasServicesFactory;
import services.ServiciosVoto;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class serviciosBancoIdeasTest {
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;
    private ServiciosVoto serviciosVoto;

    public serviciosBancoIdeasTest() throws ServicesException {
        serviciosUsuario = bancoIdeasServicesFactory.getInstance().getUsuarioTesting();
        serviciosIniciativa = bancoIdeasServicesFactory.getInstance().InsertarIniciativaTesting();
        serviciosVoto = bancoIdeasServicesFactory.getInstance().getVotoTesting();
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
            System.out.println("funciona 1");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaConsultarUsuarios() throws ServicesException, ServiciosUsuarioException {
        List<Usuario> usrPrueba = serviciosUsuario.consultarUsuarios();
        try {
            assertTrue(usrPrueba != null);
            System.out.println("funciona 2");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaActualizarUsuarios() throws ServicesException, ServiciosUsuarioException {
        Usuario userpr = new Usuario(8, "laura", "123456789", "laura@gmail.com", "Admin", "Finanzas");
        try {
            serviciosUsuario.insertarUsuario(userpr);
            serviciosUsuario.updateRolUsuario(userpr.getId(), "Admin");
            Usuario user = serviciosUsuario.consultarUsuario("laura@gmail.com");
            assertTrue("Admin".equals(user.getTipoUser()));
            //System.out.println(serviciosUsuario.consultarUsuario("laura@gmail.com"));
            System.out.println("funciona 3");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaInsertarUsuarios() throws ServicesException, ServiciosUsuarioException {
        Usuario userpr = new Usuario("laura", "1234567", "laura2@gmail.com", "Admin", "Finanzas");
        serviciosUsuario.insertarUsuario(userpr);
        try {
            assertTrue(serviciosUsuario.consultarUsuario("laura2@gmail.com") != null);
            //System.out.println(serviciosUsuario.consultarUsuario("laura2@gmail.com"));
            System.out.println("funciona 4");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaConsultarIniciativas() throws ServicesException, ServiciosUsuarioException {

        List<Iniciativa> iniciativasPrueba = serviciosIniciativa.getIniciativas();
        try {
            assertTrue(iniciativasPrueba != null);
            //System.out.println(iniciativasPrueba);
            System.out.println("funciona 5");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaInsertarIniciativa() throws ServicesException, ServiciosUsuarioException {
        Iniciativa iniciativaPrr = new Iniciativa("pruebaSietesoBien", "En espera de revisión", 1,"prueba de que funciona", "prueba", "santi", "san@gmail.com");
        serviciosIniciativa.insertIniciativa(iniciativaPrr);
        try {
            assertTrue(serviciosIniciativa.getIniciativas() != null);
            //System.out.println(serviciosIniciativa.getIniciativas());
            System.out.println("funciona 6");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaActualizarIniciativa() throws ServicesException {
        Iniciativa iniciativapr = serviciosIniciativa.getIniciativaId(1);
        serviciosIniciativa.updateIniciativa(iniciativapr.getNombre(), "En revisión");
        try {
            Iniciativa ini = serviciosIniciativa.getIniciativaId(iniciativapr.getId());
            assertTrue("En revisión".equals(ini.getEstado()));
            //System.out.println(iniciativapr);
            System.out.println("funciona 7");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void deberiaActualizarVotosIniciativa() throws ServicesException {
        Iniciativa iniciativapr = serviciosIniciativa.getIniciativaId(1);
        serviciosIniciativa.updateVotosIniciativa(iniciativapr.getNombre(), 4);
        try {
            Iniciativa ini = serviciosIniciativa.getIniciativaId(iniciativapr.getId());
            int n = ini.getNumeroVotos();
            assertTrue(n==4);
            //System.out.println(iniciativapr);
            System.out.println("funciona 8");
        } catch (Exception e) {
            System.out.println("fallas");
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
