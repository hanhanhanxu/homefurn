package hx.insist.mapper;

import hx.insist.pojo.Address;
import hx.insist.pojo.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    //得到一个用户的所有地址
    List<Address> selectAllByUid(String uid);
    //找出当前的默认地址并返回其rid
    String selectMo(String uid);
    //将默认的address设置为非默认
    void set0Mo(String rid);
    //查找此uid的默认地址的个数
    int selectCountMo(String uid);

    //通过rid查询这个地址是否是默认地址
    String queryMo(String rid);
    //查找此uid的所有不包括此rid的其他地址 中 的 一个
    Address selectOtherByUid(String uid,String rid);
    //将此rid设置为默认收货地址
    void set1Mo(String rid);
    //删除某个地址
    int deleteByRid(String rid);

    Address selectMoAddress(String uid);
}