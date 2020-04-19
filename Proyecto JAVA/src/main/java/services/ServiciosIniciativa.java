package services;

import entities.Comentario;
import entities.Iniciativa;
import exceptions.PersistenceException;
import exceptions.ServicesException;
import exceptions.ServicesException;

import java.util.List;

public interface ServiciosIniciativa {

    public List<Comentario> consultarComentarios(int idIniciativa) throws ServicesException;
    public void insertarComentario(Comentario comentario) throws ServicesException;
    public void insertIniciativa(Iniciativa iniciativa) throws PersistenceException;
    public List<Iniciativa> getIniciativas(String palabraClave)  throws PersistenceException;
    public Iniciativa getIniciativa(int id) throws PersistenceException;
    public List<Iniciativa> getIniciativas() throws PersistenceException;
    public void updateIniciativa(Iniciativa iniciativa) throws PersistenceException;

}
