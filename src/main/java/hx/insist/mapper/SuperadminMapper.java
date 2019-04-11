package hx.insist.mapper;

import hx.insist.pojo.Superadmin;
import hx.insist.pojo.SuperadminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuperadminMapper {
    int countByExample(SuperadminExample example);

    int deleteByExample(SuperadminExample example);

    int deleteByPrimaryKey(String said);

    int insert(Superadmin record);

    int insertSelective(Superadmin record);

    List<Superadmin> selectByExample(SuperadminExample example);

    Superadmin selectByPrimaryKey(String said);

    Superadmin selectByUsernamePassword(String username,String password);

    int updateByExampleSelective(@Param("record") Superadmin record, @Param("example") SuperadminExample example);

    int updateByExample(@Param("record") Superadmin record, @Param("example") SuperadminExample example);

    int updateByPrimaryKeySelective(Superadmin record);

    int updateByPrimaryKey(Superadmin record);
}