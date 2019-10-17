package hx.insist.mapper;

import hx.insist.pojo.Lunbo;
import hx.insist.pojo.LunboExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LunboMapper {
    int countByExample(LunboExample example);

    int deleteByExample(LunboExample example);

    int insert(Lunbo record);

    int insertSelective(Lunbo record);

    List<Lunbo> selectByExample(LunboExample example);

    int updateByExampleSelective(@Param("record") Lunbo record, @Param("example") LunboExample example);

    int updateByExample(@Param("record") Lunbo record, @Param("example") LunboExample example);

    List selectAll();

    int deleteByLid(String lid);

    String selectHouzhuiByLid(String lid);
}