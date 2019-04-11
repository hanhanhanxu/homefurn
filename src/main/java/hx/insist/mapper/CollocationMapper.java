package hx.insist.mapper;

import hx.insist.pojo.Collocation;
import hx.insist.pojo.CollocationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollocationMapper {
    int countByExample(CollocationExample example);

    int deleteByExample(CollocationExample example);

    int deleteByPrimaryKey(String cid);

    int insert(Collocation record);

    int insertSelective(Collocation record);

    List<Collocation> selectByExample(CollocationExample example);

    Collocation selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Collocation record, @Param("example") CollocationExample example);

    int updateByExample(@Param("record") Collocation record, @Param("example") CollocationExample example);

    int updateByPrimaryKeySelective(Collocation record);

    int updateByPrimaryKey(Collocation record);

    List selectCollocationBySid(String sid);
}