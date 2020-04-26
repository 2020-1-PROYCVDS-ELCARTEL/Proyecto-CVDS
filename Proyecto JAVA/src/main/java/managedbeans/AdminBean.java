package managedbeans;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Usuario;
import exceptions.ServiciosUsuarioException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import services.ServiciosUsuario;

@Deprecated
@ManagedBean(name = "AdminBean")
@SessionScoped

public class AdminBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{PageBean}")
    private BasePageBean baseBean;
    private ServiciosUsuario serviciosUsuario;
    private int idUser;
    private String tipoUser;
    private Usuario usuario;
    private int checkUpdate;


    public void asignarPerfil() throws ServiciosUsuarioException {
        serviciosUsuario = baseBean.getServiciosUsuario();
        checkUpdate= serviciosUsuario.updateRolUsuario(idUser, tipoUser);

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}