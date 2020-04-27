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
    //private ComentarioDAO comentarioDAO;
    private IniciativaDAO iniciativaDAO;

    @Override
    public List<Comentario> consultarComentarios(int idIniciativa) throws ServicesException {
        return null;
    }

    @Override
    public void insertarComentario(Comentario comentario) throws ServicesException {

    }

    /*@Override
        public List<Comentario> consultarComentarios(int idIniciativa) throws ServicesException {
            try {
                return comentarioDAO.getComentarios(idIniciativa);
            } catch (PersistenceException e) {
                throw new ServicesException("Error al consultar los comentarios de la iniciativa con id: "+idIniciativa, e);
            }
        }

        @Override
        public void insertarComentario(Comentario comentario) throws ServicesException {
            try {
                comentarioDAO.insertComentario(comentario);
            }
            catch (PersistenceException e) {
                throw new ServicesException("Error al insertar comentario", e);
            }
        }
    */
    @Override
    public int insertIniciativa(Iniciativa iniciativa) throws ServicesException {
        try {
            return iniciativaDAO.insertIniciativa(iniciativa);
        }
        catch (PersistenceException e) {
            throw new ServicesException("Error al insertar iniciativa", e);
        }
    }


    @Override
    public List<Iniciativa> getIniciativas(String palabraClave) throws ServicesException {
        List<Iniciativa> iniciativas;
        try {
            iniciativas = iniciativaDAO.getIniciativas(palabraClave);
        }
        catch (PersistenceException e) {
            throw new ServicesException("Error al consultar a las iniciativas", e);
        }
        return iniciativas;
    }

    @Override
    public Iniciativa getIniciativa(int id) throws ServicesException {
        Iniciativa iniciativa=null;
        try {
            iniciativa = iniciativaDAO.getIniciativa(id);
        }
        catch (PersistenceException e) {
            throw new ServicesException("Error al consultar la iniciativa con id: "+id, e);
        }
        return iniciativa;
    }

    @Override
    public List<Iniciativa> getIniciativas() throws ServicesException {
        List<Iniciativa> iniciativas;
        try {
            iniciativas = iniciativaDAO.getIniciativas();
        }
        catch (PersistenceException e) {
            throw new ServicesException("Error al consultar a las iniciativas", e);
        }
        return iniciativas;
    }

    @Override
    public int updateIniciativa(Iniciativa iniciativa) throws ServicesException {
        try{
            return iniciativaDAO.updateIniciativa(iniciativa);
        } catch (PersistenceException e) {
            throw new ServicesException("Error al actualizar la iniciativa:"+iniciativa.toString(), e);
        }
    }
}
