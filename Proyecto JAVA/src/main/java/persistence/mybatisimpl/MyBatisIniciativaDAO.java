package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Iniciativa;
import exceptions.PersistenceException;
import persistence.IniciativaDAO;
import persistence.mybatisimpl.mappers.IniciativaMapper;


import java.util.List;

public class MyBatisIniciativaDAO implements IniciativaDAO {
    @Inject
    IniciativaMapper iniciativaMapper;
    @Override
    public void insertIniciativa(Iniciativa iniciativa) throws PersistenceException {
        try {
            iniciativaMapper.insertIniciativa(iniciativa);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Save error iniciativa");
        }
    }

    @Override
    public List<Iniciativa> getIniciativas(String palabraClave) throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativas(palabraClave);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error iniciativa str palabras clave");
        }
    }

    @Override
    public Iniciativa getIniciativa(int id) throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativa(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error iniciativa id");
        }
    }

    @Override
    public List<Iniciativa> getIniciativas() throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativas();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error iniciativa todas, sin parametro");
        }
    }

    @Override
    public void updateIniciativa(String nombreIniciativa) throws PersistenceException {
        try {
            iniciativaMapper.updateIniciativa(nombreIniciativa);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Update error iniciativa nombre");
        }
    }
}
