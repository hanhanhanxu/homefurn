package hx.insist.mapper;

import hx.insist.pojo.Suit;
import hx.insist.pojo.SuitExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SuitMapper {
    int countByExample(SuitExample example);

    int deleteByExample(SuitExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Suit record);

    int insertSelective(Suit record);

    List<Suit> selectByExample(SuitExample example);

    Suit selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Suit record, @Param("example") SuitExample example);

    int updateByExample(@Param("record") Suit record, @Param("example") SuitExample example);

    int updateByPrimaryKeySelective(Suit record);

    int updateByPrimaryKey(Suit record);

    List findAllByUid(String uid);
    List findAllByUidOrdered(String uid);

    void updateSprice(String sid,BigDecimal fprice);

    int updateSsign(String sid);
}