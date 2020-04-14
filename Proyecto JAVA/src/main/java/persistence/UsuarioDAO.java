package persistence;

import entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioDAO {
    public void insertUsuario(Usuario usuario) throws PersistenceException;
    public Usuario getUsuario(String correo) throws PersistenceException;
    //public void update(Usuario usuario) throws PersistenceException;
    //public void remove(Usuario usuario);
    //public Usuario load(Object id) throws PersistenceException;
    public List<Usuario> getUsuarios() throws PersistenceException;
}
