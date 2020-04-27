package managedbeans;

import entities.Iniciativa;
import entities.Usuario;
import exceptions.ServicesException;
import services.ServiciosIniciativa;
import services.ServiciosUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Deprecated
@ManagedBean(name = "IniciativaBean")
@SessionScoped

public class IniciativaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{PageBean}")
    private BasePageBean baseBean;
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;
    private Iniciativa iniciativa;
    private int checkUpdate;
    private String nombreIniciativa;
    private String descripcionIniciativa;
    private String palabrasClave;
    private String nombreUsuario;
    private String correoUsuario;
    private Usuario usuario;


    public List<Iniciativa> getIniciativas() throws ServicesException {
        configBasica();
        return serviciosIniciativa.getIniciativas();
    }


    public void configBasica() {
        setServiciosIniciativa(baseBean.getServiciosIniciativa());
        setServiciosUsuario(baseBean.getServiciosUsuario());
        setUsuario(baseBean.getUser());
        setNombreUsuario(usuario.getNombre());
        setCorreoUsuario(usuario.getCorreo());
    }
    public void agregarIniciativa() throws ServicesException {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Pro.xhtml");
            checkUpdate = serviciosIniciativa.insertIniciativa(new Iniciativa(nombreIniciativa, "En espera de revisión", 0, descripcionIniciativa, palabrasClave, nombreUsuario, correoUsuario));
        } catch (IOException e) {
            this.baseBean.mensajeApp(e);
            e.printStackTrace();
        }


    }

    public BasePageBean getBaseBean() {
        return baseBean;
    }

    public void setBaseBean(BasePageBean baseBean) {
        this.baseBean = baseBean;
    }

    public ServiciosUsuario getServiciosUsuario() {
        return serviciosUsuario;
    }

    public void setServiciosUsuario(ServiciosUsuario serviciosUsuario) {
        this.serviciosUsuario = serviciosUsuario;
    }

    public ServiciosIniciativa getServiciosIniciativa() {
        return serviciosIniciativa;
    }

    public void setServiciosIniciativa(ServiciosIniciativa serviciosIniciativa) {
        this.serviciosIniciativa = serviciosIniciativa;
    }

    public Iniciativa getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
    }

    public String getNombreIniciativa() {
        return nombreIniciativa;
    }

    public void setNombreIniciativa(String nombreIniciativa) {
        this.nombreIniciativa = nombreIniciativa;
    }

    public String getDescripcionIniciativa() {
        return descripcionIniciativa;
    }

    public void setDescripcionIniciativa(String descripcionIniciativa) {
        this.descripcionIniciativa = descripcionIniciativa;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}