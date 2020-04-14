import entities.Usuario;
import org.junit.Test;
import exceptions.PersistenceException;
import persistence.UsuarioDAO;
import persistence.mybatisimpl.MyBatisUsuarioDAO;

import static com.google.inject.Guice.createInjector;

public class UsuarioTest {


    private Usuario usuario;

    private UsuarioDAO usuarioDAO;

    @Test
    public void probarInsertUsuario(){
        usuarioDAO = new MyBatisUsuarioDAO();
        usuario = new Usuario(2, "juan", "1234", "juan@gmail.com", "Admin");
        try {
            usuarioDAO.insertUsuario(usuario);
        } catch (PersistenceException e) {
            System.out.println("Fallo la prueba");
            e.printStackTrace();

        }
    }
}
