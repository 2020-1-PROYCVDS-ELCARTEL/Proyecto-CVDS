package services.impl;

import entities.Comentario;
import entities.Iniciativa;
import exceptions.PersistenceException;
import exceptions.ServicesException;
import services.ServiciosIniciativa;

import java.util.List;

public class ServiciosIniciativaImpl implements ServiciosIniciativa {
    @Override
    public List<Comentario> consultarComentarios(int idIniciativa) throws ServicesException {
        return null;
    }

    @Override
    public void insertarComentario(Comentario comentario) throws ServicesException {

    }

    @Override
    public void insertIniciativa(Iniciativa iniciativa) throws PersistenceException {

    }

    @Override
    public List<Iniciativa> getIniciativas(String palabraClave) throws PersistenceException {
        return null;
    }

    @Override
    public Iniciativa getIniciativa(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Iniciativa> getIniciativas() throws PersistenceException {
        return null;
    }

    @Override
    public void updateIniciativa(Iniciativa iniciativa) throws PersistenceException {

    }
}
