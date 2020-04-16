package services.impl;

import java.util.List;

import com.google.inject.Inject;

import exceptions.PersistenceException;
import exceptions.ServiciosUsuarioException;
import persistence.UsuarioDAO;

import entities.Usuario;
import services.ServiciosUsuario;

public class ServiciosUsuarioImpl implements ServiciosUsuario {

    @Inject
    private UsuarioDAO userDAO;


    @Override
    public Usuario consultarUsuario(String correo) throws ServiciosUsuarioException{
        Usuario u=null;
        try {
            u = userDAO.getUsuario(correo);
        }
        catch (PersistenceException e) {
            throw new ServiciosUsuarioException("Error al consultar el usuario "+correo, e);
        }
        return u;
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ServiciosUsuarioException{
        List<Usuario> users;
        try {
            users = userDAO.getUsuarios();
        }
        catch (PersistenceException e) {
            throw new ServiciosUsuarioException("Error al consultar a los usuarios", e);
        }
        return users;
    }

    @Override
    public void insertarUsuario(Usuario user) throws ServiciosUsuarioException {
        try {
            userDAO.insertUsuario(user);
        }
        catch (PersistenceException e) {
            throw new ServiciosUsuarioException("Error al insertar usuario", e);
        }

    }

    public boolean validarLogin(String correo, String password) throws ServiciosUsuarioException {
        Usuario usuario = consultarUsuario(correo);
        boolean bandera = false;
        if(password==usuario.getcontrasena()){
            bandera = true;
        }
        return bandera;
    }


}