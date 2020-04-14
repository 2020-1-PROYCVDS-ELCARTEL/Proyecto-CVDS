package entities;

public class Usuario {

    private int id;
    private String nombre;
    private String contraseña;
    private String correo;
    private String tipoUsuario;
    private String dependencia;

    public Usuario(int id, String nombre, String contraseña, String correo, String tipoUsuario, String dependencia) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.dependencia = dependencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public String getDependencia() {return dependencia; }

    public void setDependencia(String dependencia) { this.dependencia = dependencia; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
