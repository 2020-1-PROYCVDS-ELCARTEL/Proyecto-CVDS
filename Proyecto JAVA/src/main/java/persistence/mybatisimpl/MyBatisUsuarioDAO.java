package persistence.mybatisimpl;

import java.util.List;

import entities.Usuario;


import com.google.inject.Inject;

import persistence.PersistenceException;
import persistence.UsuarioDAO;
import persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBatisUsuarioDAO implements UsuarioDAO {
    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public void save(Usuario usuario) throws PersistenceException {
        try {
            usuarioMapper.insertUsuario(usuario);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Save error");
        }
    }

    @Override
    public List<Usuario> loadAll() throws PersistenceException {
        try {
            return usuarioMapper.getUsuarios();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error");
        }
    }
}
