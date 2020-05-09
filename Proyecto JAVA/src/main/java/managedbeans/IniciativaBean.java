package managedbeans;

import entities.Comentario;
import entities.Iniciativa;
import entities.Usuario;
import entities.Voto;
import exceptions.PersistenceException;
import exceptions.ServicesException;
import exceptions.ServiciosUsuarioException;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import services.ServiciosComentario;
import services.ServiciosIniciativa;
import services.ServiciosUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;
import services.ServiciosVoto;


@Deprecated
@ManagedBean(name = "IniciativaBean")
@SessionScoped

public class IniciativaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{PageBean}")
    private BasePageBean baseBean;
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;
    private ServiciosVoto serviciosVoto;
    private ServiciosComentario serviciosComentario;
    //private Iniciativa iniciativa;
    private int checkUpdate;
    private String nombreIniciativa;
    private String descripcionIniciativa;
    private String palabrasClave;
    private String estado;
    private String nombreUsuario;
    private String correoUsuario;
    private Usuario usuario;
    private Iniciativa iniciativaConsultadaId;
    private List<Integer> estadistica;
	private BarChartModel model;
	private List<Comentario> comentarios;

    public void Bean() {
        model = new BarChartModel();
        ChartSeries e= new ChartSeries();
        e.setLabel("Estadisticas");
        e.set("Finanzas", estadistica.get(0));
		e.set("Administrativo", estadistica.get(1));
		e.set("Recursos humanos", estadistica.get(2));
		e.set("TI", estadistica.get(3));
		e.set("Unidad de proyectos", estadistica.get(4));
		model.addSeries(e);
		model.setTitle("Estadísticas");
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Dependencias");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Iniciativas registradas");
        yAxis.setMin(0);
        yAxis.setMax(15);
	}

	public BarChartModel getModel() {
        return model;
    }

    public void setModel(BarChartModel model) {
        this.model = model;
    }

    public List<Iniciativa> getIniciativas(){
        configBasica();
        List<Iniciativa> iniciativas = null;
        try {
            iniciativas = serviciosIniciativa.getIniciativas();
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
        return iniciativas;
    }

    public List<Iniciativa> getMisIniciativas(){
        List<Iniciativa> iniciativas1 = null;
        try {
            iniciativas1 = serviciosIniciativa.getIniciativaProponente(usuario.getNombre());
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
        return iniciativas1;
    }

    public List<Iniciativa> getIniciativasEst(){
        List<Iniciativa> iniciativaEst = null;
        try {
            iniciativaEst = serviciosIniciativa.getIniciativasEst(estado);
        } catch (Exception e) {
            this.baseBean.mensajeApp(e);
        }
        return iniciativaEst;
    }

    public void actualizarIniciativa() {
        try {
            serviciosIniciativa.updateIniciativa(nombreIniciativa, estado);
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void verIniciativa(int idIniciativa){
        try {
            iniciativaConsultadaId = serviciosIniciativa.getIniciativaId(idIniciativa);
            comentarios = serviciosComentario.getComentarios(idIniciativa);
            if(usuario.getTipoUser().equals("PMO")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/ModificarIniciativa.xhtml");
            }else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/verIniciativa.xhtml");
            }
        } catch (IOException | ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void modificar(int idIniciativa){
        try {
            modificarIniciativa(idIniciativa);
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void modificarIniciativa(int idIniciativa) throws ServicesException{
        try {
            iniciativaConsultadaId = serviciosIniciativa.getIniciativaId(idIniciativa);
            if(iniciativaConsultadaId.getEstado().equals("En espera de revisión")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/actualizarIniciativa.xhtml");
            } else {
                throw new ServicesException("No se puede actualizar esta iniciativa, ya ha cambiado de estado");
            }
        } catch (IOException | ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void guardarComentario(String comentario){
        Comentario comentario1 = new Comentario(comentario, iniciativaConsultadaId.getId(), usuario.getId());
        try{
            serviciosComentario.insertComentario(comentario1);
            comentarios = serviciosComentario.getComentarios(iniciativaConsultadaId.getId());
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void iniciativaPorArea(){
        estadistica = new ArrayList<Integer>();
        try {
            int finanzas =0;
            int administrativo=0;
            int recursosHumanos=0;
            int TI=0;
            int unidadDeProyectos = 0;
            List<Iniciativa> iniciativas = serviciosIniciativa.getIniciativas();
            List<Usuario> usuarios = serviciosUsuario.consultarUsuarios();
            for(int i=0; i<iniciativas.size(); i++){
                for(int j=0; j<usuarios.size(); j++){
                    if(iniciativas.get(i).getCorreoUsuario().equals(usuarios.get(j).getCorreo())){
                        if(usuarios.get(j).getDependencia().equals("Finanzas")){ finanzas+=1; }
                        else if(usuarios.get(j).getDependencia().equals("Administrativo")){ administrativo+=1; }
                        else if(usuarios.get(j).getDependencia().equals("Recursos Humanos")){ recursosHumanos+=1; }
                        else if(usuarios.get(j).getDependencia().equals("TI")){ TI+=1; }
                        else if(usuarios.get(j).getDependencia().equals("Unidad de proyectos")){ unidadDeProyectos+=1; }
                    }
                }
            }
            estadistica.add(finanzas);
            estadistica.add(administrativo);
            estadistica.add(recursosHumanos);
            estadistica.add(TI);
            estadistica.add(unidadDeProyectos);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/informes.xhtml");
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        } catch (ServiciosUsuarioException e) {
            this.baseBean.mensajeApp(e);
        } catch (IOException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void configBasica() {
        setServiciosIniciativa(baseBean.getServiciosIniciativa());
        setServiciosUsuario(baseBean.getServiciosUsuario());
        setServiciosVoto(baseBean.getServiciosVoto());
        setServiciosComentario(baseBean.getServiciosComentario());
        setUsuario(baseBean.getUser());
        setNombreUsuario(usuario.getNombre());
        setCorreoUsuario(usuario.getCorreo());
    }

    public void borrarForm() {
        setDescripcionIniciativa("");
        setNombreIniciativa("");
        setPalabrasClave("");
        setPalabrasClave("");
        setEstado("");
    }

    public void agregarIniciativa() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Pro.xhtml");
            checkUpdate = serviciosIniciativa.insertIniciativa(new Iniciativa(nombreIniciativa, "En espera de revisión", 0, descripcionIniciativa, palabrasClave, nombreUsuario, correoUsuario));
            borrarForm();
        } catch (IOException | ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void votar(){
        try {
            Voto voto = new Voto(usuario.getId(), iniciativaConsultadaId.getId());
            //serviciosVoto.getVoto(usuario.getId(), iniciativaConsultadaId.getId());
            serviciosVoto.insertVoto(voto);
            serviciosIniciativa.updateVotosIniciativa(iniciativaConsultadaId.getNombre(), iniciativaConsultadaId.getNumeroVotos()+1);
            iniciativaConsultadaId = serviciosIniciativa.getIniciativaId(iniciativaConsultadaId.getId());
        }catch (Exception e){
            if(e.getMessage().equals("Error al insertar voto")){
                try {
                    serviciosVoto.deleteVoto(usuario.getId(), iniciativaConsultadaId.getId());
                    serviciosIniciativa.updateVotosIniciativa(iniciativaConsultadaId.getNombre(), iniciativaConsultadaId.getNumeroVotos()-1);
                    iniciativaConsultadaId = serviciosIniciativa.getIniciativaId(iniciativaConsultadaId.getId());
                } catch (ServicesException ex) {
                    this.baseBean.mensajeApp(e);
                }
            }else {
                this.baseBean.mensajeApp(e);
            }
        }
    }


    private void cambiarEstado(String nuevoEstado){
        try {
            serviciosIniciativa.updateIniciativa(iniciativaConsultadaId.getNombre(), estado);
            iniciativaConsultadaId = serviciosIniciativa.getIniciativaId(iniciativaConsultadaId.getId());
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
        }
    }

    public void cambiarEstado() throws ServicesException {
        if(estado !=null && !estado.equals("")) {
            cambiarEstado(estado);
        }else {
            throw new ServicesException("Fallo al actualizar el estado de la iniciativa");
        }
    }

    public void actualizarLaIniciativa(){
        try {
            serviciosIniciativa.updateIniciativaDesc(iniciativaConsultadaId.getId(), iniciativaConsultadaId.getDescripcion());
            serviciosIniciativa.updateIniciativaPalabrasC(iniciativaConsultadaId.getId(), iniciativaConsultadaId.getPalabrasClave());
            serviciosIniciativa.updateIniciativaNombre(iniciativaConsultadaId.getId(), iniciativaConsultadaId.getNombre());
        } catch (ServicesException e) {
            this.baseBean.mensajeApp(e);
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Integer> getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(List<Integer> estadistica) {
        this.estadistica = estadistica;
    }

    public Iniciativa getIniciativaConsultadaId() {
        return iniciativaConsultadaId;
    }

    public void setIniciativaConsultadaId(Iniciativa iniciativaConsultadaId) {
        this.iniciativaConsultadaId = iniciativaConsultadaId;
    }

    public ServiciosVoto getServiciosVoto() {
        return serviciosVoto;
    }

    public void setServiciosVoto(ServiciosVoto serviciosVoto) {
        this.serviciosVoto = serviciosVoto;
    }

    public ServiciosComentario getServiciosComentario() {
        return serviciosComentario;
    }

    public void setServiciosComentario(ServiciosComentario serviciosComentario) {
        this.serviciosComentario = serviciosComentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}