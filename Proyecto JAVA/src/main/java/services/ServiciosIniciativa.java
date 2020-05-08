package services;

import entities.Iniciativa;
import exceptions.ServicesException;

import java.util.List;

public interface ServiciosIniciativa {
    public int insertIniciativa(Iniciativa iniciativa) throws ServicesException;
    public List<Iniciativa> getIniciativas(String palabraClave) throws ServicesException;
    public Iniciativa getIniciativaId(int id) throws ServicesException;
    public Iniciativa getIniciativaNombre(String nombre) throws ServicesException;
    public List<Iniciativa> getIniciativas() throws ServicesException;
    public int updateIniciativa(String nombre, String estado) throws ServicesException;
    public int updateVotosIniciativa(String nombre, int numerovotos) throws ServicesException;
    public List<Iniciativa> getIniciativaProponente(String nombreusuario) throws ServicesException;
	public int updateIniciativaDesc(String nombre, String descripcionIniciativa) throws ServicesException;
}
