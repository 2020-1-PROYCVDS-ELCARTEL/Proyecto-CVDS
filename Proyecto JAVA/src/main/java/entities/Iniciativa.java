package entities;
import java.util.Date;
import java.util.List;

public class Iniciativa {
    private int id;
    private String nombreIniciativa;
    private String estado;
    private int numeroVotos;
    private String palabrasClave;
    private String nombreUsuario;
    private String correoUsuario;
    private Date fecha;
    private List<Comentario> comentarioList;

    public Iniciativa(int id, String nombreIniciativa, String estado, int numeroVotos, String palabrasClave, String nombreUsuario, String correoUsuario, Date fecha) {
        this.id = id;
        this.nombreIniciativa = nombreIniciativa;
        this.estado = estado;
        this.numeroVotos = numeroVotos;
        this.palabrasClave = palabrasClave;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreIniciativa() {
        return nombreIniciativa;
    }

    public void setNombreIniciativa(String nombreIniciativa) {
        this.nombreIniciativa = nombreIniciativa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(int numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public String toString() {
        return "Iniciativa{" +
                "id=" + id +
                ", nombreIniciativa='" + nombreIniciativa + '\'' +
                ", estado='" + estado + '\'' +
                ", numeroVotos=" + numeroVotos +
                ", palabrasClave='" + palabrasClave + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", fecha=" + fecha +
                '}';
    }


}
