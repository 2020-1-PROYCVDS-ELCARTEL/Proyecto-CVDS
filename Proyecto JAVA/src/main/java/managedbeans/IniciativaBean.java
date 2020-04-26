package managedbeans;

import entities.Iniciativa;
import entities.Usuario;
import exceptions.ServicesException;
import services.ServiciosIniciativa;
import services.ServiciosUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Deprecated
@ManagedBean(name = "IniciativaBean")
@SessionScoped

public class IniciativaBean implements Serializable {
    @ManagedProperty(value = "#{PageBean}")
    private BasePageBean baseBean;
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;
    private Iniciativa iniciativa;
    private int checkUpdate;

    public List<Iniciativa> getIniciativas() throws ServicesException {
        return serviciosIniciativa.getIniciativas();
    }

    public void AgregarIniciativa() throws ServicesException {
        serviciosUsuario = baseBean.getServiciosUsuario();
        checkUpdate = serviciosIniciativa.insertIniciativa(iniciativa);
    }

}