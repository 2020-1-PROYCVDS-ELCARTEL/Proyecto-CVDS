package persistence.mybatisimpl.mappers;

import entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioMapper {
    public void insertUsuario(Usuario usuario);
    public Usuario getUsuario(@Param("correoUser")String correo);
    public List<Usuario> getUsuarios();
    public void deleteAll();
}
