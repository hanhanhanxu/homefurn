package hx.insist.mapper;

import hx.insist.pojo.Style;
import hx.insist.pojo.StyleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StyleMapper {
    int countByExample(StyleExample example);

    int deleteByExample(StyleExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Style record);

    int insertSelective(Style record);

    List<Style> selectByExample(StyleExample example);

    Style selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Style record, @Param("example") StyleExample example);

    int updateByExample(@Param("record") Style record, @Param("example") StyleExample example);

    int updateByPrimaryKeySelective(Style record);

    int updateByPrimaryKey(Style record);

    int selectByTname(String styleName);

    List selectAll();
}