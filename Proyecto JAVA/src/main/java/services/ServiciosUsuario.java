package services;

import java.util.List;

import exceptions.ServiciosUsuarioException;
import entities.Usuario;

public interface ServiciosUsuario {



    public Usuario consultarUsuario(String correo) throws ServiciosUsuarioException;

    public List<Usuario>consultarUsuarios() throws ServiciosUsuarioException;

    public void insertarUsuario(Usuario user) throws ServiciosUsuarioException;



}