package entities;

public class Comentario {
    private int id;
    private String textoComentario;
    private int idIniciativa;

    public Comentario(int id, String textoComentario, int idIniciativ) {
        this.id = id;
        this.textoComentario = textoComentario;
        this.idIniciativa = idIniciativ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public int getIdIniciativa() {
        return idIniciativa;
    }

    public void setIdIniciativa(int idIniciativa) {
        this.idIniciativa = idIniciativa;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", textoComentario='" + textoComentario + '\'' +
                ", idIniciativ=" + idIniciativa +
                '}';
    }
}
