package persistence.mybatisimpl.mappers;

import entities.Iniciativa;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativaMapper {
    public int insertIniciativa(Iniciativa iniciativa);
    public List<Iniciativa> getIniciativasPaClave(@Param("palabraClave")String palabraClave);
    public Iniciativa getIniciativaId(@Param("idIniciativa")int id);
    public Iniciativa getIniciativaNombre(@Param("nombreIniciativa")String nombreIniciativa);
    public List<Iniciativa> getIniciativasAll();
    public int updateIniciativa(@Param("nombre") String nombre, @Param("estado")String estado);
    public int updateVotosIniciativa(@Param("nombre") String nombre, @Param("numerovotos")int numerovotos);
    //public void deleteAll();
}

