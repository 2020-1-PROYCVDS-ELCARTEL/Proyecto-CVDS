package persistence.mybatisimpl.mappers;

import entities.Iniciativa;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IniciativaMapper {
    public int insertIniciativa(Iniciativa iniciativa);
    public List<Iniciativa> getIniciativasPaClave(@Param("palabraClave")String palabraClave);
    public Iniciativa getIniciativaId(@Param("idIniciativa")int id);
    public List<Iniciativa> getIniciativasAll();
    public int updateIniciativa(Iniciativa iniciativa);
    //public void deleteAll();
}

