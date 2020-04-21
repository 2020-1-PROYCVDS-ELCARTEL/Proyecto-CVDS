package services.impl;

import com.google.inject.Inject;
import entities.Comentario;
import entities.Iniciativa;
import entities.Usuario;
import exceptions.PersistenceException;
import exceptions.ServicesException;
import exceptions.ServiciosUsuarioException;
import persistence.ComentarioDAO;
import persistence.IniciativaDAO;
import services.ServiciosIniciativa;

import java.util.List;

public class ServiciosIniciativaImpl implements ServiciosIniciativa {

    @Inject
    private List<ComentarioDAO> comentarioDAOList;
    private IniciativaDAO iniciativaDAO;

    @Override
    public List<Comentario> consultarComentarios(int idIniciativa) throws ServicesException {
        return null;
    }

    @Override
    public void insertarComentario(Comentario comentario) throws ServicesException {

    }

    @Override
    public void insertIniciativa(Iniciativa iniciativa) throws ServicesException {

    }

    @Override
    public List<Iniciativa> getIniciativas(String palabraClave) throws ServicesException {
        List<Iniciativa> iniciativas;
        try {
            iniciativas = iniciativaDAO.getIniciativas();
        }
        catch (PersistenceException e) {
            throw new ServicesException("Error al consultar a los usuarios", e);
        }
        return iniciativas;
    }

    @Override
    public Iniciativa getIniciativa(int id) throws ServicesException {
        return null;
    }

    @Override
    public List<Iniciativa> getIniciativas() throws ServicesException {
        return null;
    }

    @Override
    public void updateIniciativa(Iniciativa iniciativa) throws ServicesException {

    }
}
