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
    public int insertIniciativa(Iniciativa iniciativa) throws PersistenceException {
        try {
            return iniciativaMapper.insertIniciativa(iniciativa);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Save error iniciativa");
        }
    }

    @Override
    public List<Iniciativa> getIniciativas(String palabraClave) throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativasPaClave(palabraClave);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error iniciativa str palabras clave");
        }
    }

    @Override
    public Iniciativa getIniciativa(int id) throws PersistenceException {
        Iniciativa iniciativa = iniciativaMapper.getIniciativaId(id);
        if(iniciativa==null) throw new PersistenceException("Error al cargar la iniciativa id:"+id+"No esxiste ninguna con ese id");
        else return iniciativa;
    }

    @Override
    public List<Iniciativa> getIniciativas() throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativasAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Load error iniciativa todas, sin parametro");
        }
    }

    @Override
    public int updateIniciativa(String nombre, String estado) throws PersistenceException {
        try {
             return iniciativaMapper.updateIniciativa(nombre, estado);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Update error iniciativa nombre");
        }
    }
}
