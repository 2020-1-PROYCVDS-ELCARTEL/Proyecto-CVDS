package persistence;

import entities.Iniciativa;
import exceptions.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativaDAO {
    public void insertIniciativa(Iniciativa iniciativa) throws PersistenceException;
    public List<Iniciativa> getIniciativas(String palabraClave)  throws PersistenceException;
    public Iniciativa getIniciativa(int id) throws PersistenceException;
    public List<Iniciativa> getIniciativas() throws PersistenceException;
    public void updateIniciativa(Iniciativa iniciativa) throws PersistenceException;


}
