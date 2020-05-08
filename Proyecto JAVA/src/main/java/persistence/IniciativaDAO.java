package persistence;

import entities.Iniciativa;
import exceptions.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativaDAO {
    public int insertIniciativa(Iniciativa iniciativa) throws PersistenceException;
    public List<Iniciativa> getIniciativas(String palabraClave)  throws PersistenceException;
    public Iniciativa getIniciativaId(int id) throws PersistenceException;
    public Iniciativa getIniciativaNombre(String nombreIniciativa) throws PersistenceException;
    public List<Iniciativa> getIniciativas() throws PersistenceException;
    public int updateIniciativa(String nombre, String estado) throws PersistenceException;
    public int updateVotosIniciativa(String nombre, int numerovotos) throws PersistenceException;
    public List<Iniciativa> getIniciativaProponente(String nombreusuario) throws PersistenceException;
	public int updateIniciativaDesc(String nombre, String descripcionIniciativa) throws PersistenceException;
}
