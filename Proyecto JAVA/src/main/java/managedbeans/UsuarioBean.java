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
@ManagedBean(name = "LoginBean")
@SessionScoped

public class UsuarioBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{PageBean}")
    private BasePageBean baseBean;

    private String usuarioCorreo;
    private String password;
    private boolean rememberMe;
    private boolean noLogged;
    private ServiciosUsuario serviciosUsuario;
    private Usuario usuario;
    private String rolUsuario;
    private String nombreUsuario;

    public void login() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            session.setAttribute("correo", "password");
            UsernamePasswordToken token = new UsernamePasswordToken(usuarioCorreo, password);

            currentUser.login(token);

            token.setRememberMe(true);
            if (currentUser.isAuthenticated()){
                serviciosUsuario = baseBean.getServiciosUsuario();
                setUsuario(serviciosUsuario.consultarUsuario(usuarioCorreo));
                setNombreUsuario(usuario.getNombre());
                setRolUsuario(usuario.getTipoUser());
                redirectToMenu();
            }
        } catch (UnknownAccountException e) {
            this.baseBean.mensajeApp(e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuario no encontrado", "Este usuario no se encuentra en nuestra base de datos"));
        }

        catch (IncorrectCredentialsException e) {
            this.baseBean.mensajeApp(e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Contraseña incorrecta", "La contraseña ingresada no es correcta"));

        } catch (ServiciosUsuarioException e) {
            e.printStackTrace();
        }
    }

   /* public String getUsuarioName(){
        return variable;
    }*/

    public boolean isNoLogged() {
        return noLogged;
    }

    public void setNoLogged(boolean noLogged) {
        this.noLogged = noLogged;
    }

    public void logout() {
        try {
            if(getUser().isAuthenticated()) {
                getUser().logout();

                redirectTo("/faces/iniciosesion.xhtml");

            }
        }
        catch(Exception e) {
            this.baseBean.mensajeApp(e);
            e.printStackTrace();

        }

    }

    public void redirectToMenu(){
        if(getUser()!=null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/menu.xhtml");
            } catch (IOException e) {
                this.baseBean.mensajeApp(e);
                e.printStackTrace();
            }
        }

    }


    public void isLogged(){
        Subject subject = SecurityUtils.getSubject();
        if ((subject.getSession().getAttribute("correo") != null) && subject.getSession().getAttribute("correo")!="NoRegistrado"){
            //redirectToMenu();
        }
        else{
            usuarioCorreo = null;
            password = null;
        }
    }

    public void redirectTo(String path){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(path);
        } catch (IOException e) {
            this.baseBean.mensajeApp(e);
            e.printStackTrace();
        }
    }


    //Gets and Sets
    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.usuarioCorreo;
    }

    public void setUserName(String userName) {
        this.usuarioCorreo = userName;
    }

    private Subject getUser() {
        return SecurityUtils.getSubject();
    }

    public BasePageBean getBaseBean() {
        return this.baseBean;
    }

    public void setBaseBean(BasePageBean bs){
        this.baseBean = bs;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
