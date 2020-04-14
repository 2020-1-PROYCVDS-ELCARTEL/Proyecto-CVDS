package persistence.mybatisimpl.mappers;
import entities.Iniciativa;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativaMapper {
    public void insertIniciativa(Iniciativa iniciativa);
    public List<Iniciativa> getIniciativas(@Param("palabraClave")String palabraClave);
    public Iniciativa getIniciativa(@Param("idIniciativa")int id);
    public List<Iniciativa> getIniciativas();
    public void updateIniciativa(@Param("nombreIniciativa")String nombreIniciativa);
    //public void deleteAll();
}

