package persistence.mybatisimpl.mappers;

import entities.Usuario;

import java.util.List;

public interface UsuarioMapper {
    public void insertUsuario(Usuario usuario);
    public List<Usuario> getUsuarios();
    public void deleteAll();
}
