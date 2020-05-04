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
    public int insertIniciativa(Iniciativa iniciativa) throws ServicesException;
    public List<Iniciativa> getIniciativas(String palabraClave) throws ServicesException;
    public Iniciativa getIniciativaId(int id) throws ServicesException;
    public Iniciativa getIniciativaNombre(String nombre) throws ServicesException;
    public List<Iniciativa> getIniciativas() throws ServicesException;
    public int updateIniciativa(String nombre, String estado) throws ServicesException;
    public int updateVotosIniciativa(String nombre, int numerovotos) throws ServicesException;

}
