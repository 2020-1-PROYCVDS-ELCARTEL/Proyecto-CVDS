package persistence;

import entities.Iniciativa;
import exceptions.PersistenceException;
import java.util.List;

public interface IniciativaDAO {
    public int insertIniciativa(Iniciativa iniciativa) throws PersistenceException;
    public List<Iniciativa> getIniciativas(String palabraClave)  throws PersistenceException;
    public Iniciativa getIniciativa(int id) throws PersistenceException;
    public List<Iniciativa> getIniciativas() throws PersistenceException;
    public int updateIniciativa(String nombre, String estado) throws PersistenceException;


}
