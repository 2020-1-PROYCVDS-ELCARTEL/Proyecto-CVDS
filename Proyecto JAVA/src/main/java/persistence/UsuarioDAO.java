package persistence;

import entities.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public void save(Usuario usuario) throws PersistenceException;
    //public void update(Usuario usuario) throws PersistenceException;
    //public void remove(Usuario usuario);
    //public Usuario load(Object id) throws PersistenceException;
    public List<Usuario> loadAll() throws PersistenceException;
}
