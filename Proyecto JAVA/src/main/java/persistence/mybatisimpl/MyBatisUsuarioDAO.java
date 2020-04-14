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
    public void insertUsuario(Usuario usuario) throws PersistenceException {
        try {
            usuarioMapper.insertUsuario(usuario);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Save error");
        }
    }

    @Override
    public Usuario getUsuario(String correo) throws PersistenceException {
        Usuario user=usuarioMapper.getUsuario(correo);
        if(user==null) throw new PersistenceException("Error al consultar cliente "+ correo+
                " - No existe");
        else return user;
    }

    @Override
    public List<Usuario> getUsuarios() throws PersistenceException {
        try {
            return usuarioMapper.getUsuarios();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error");
        }
    }
}
