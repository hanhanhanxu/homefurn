package hx.insist.mapper;

import hx.insist.pojo.Orderinfo;
import hx.insist.pojo.OrderinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderinfoMapper {
    int countByExample(OrderinfoExample example);

    int deleteByExample(OrderinfoExample example);

    int deleteByPrimaryKey(String ofid);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    List<Orderinfo> selectByExample(OrderinfoExample example);

    Orderinfo selectByPrimaryKey(String ofid);

    int updateByExampleSelective(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByExample(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);

    List<Orderinfo> selectAllByUid(String uid);
    List<Orderinfo> selectAllByUidAndOfstate(String uid,String string);

    List<Orderinfo> selectAll();
    List<Orderinfo> selectAllByOfstate(String string);

    int updateOfstate1ByOfid(String ofid);//将 待发货 的状态状态改为 已发货
    int updateOfstate2ByOfid(String ofid);//将 已发货 的状态状态改为 已收货
}