package hx.insist.service;

import hx.insist.pojo.Address;

import java.util.List;

public interface AddressService {
    void add(Address address);
    List<Address> getAllByUid(String uid);
    void updateMo(String uid);//更新默认收货地址：如果存在默认收货地址就将其设置为非默认
    int getCountMo(String uid);//查找此人是否存在默认收货地址

    Address getOtherByUid(String uid,String rid);//通过uid查找除了此收货地址外的任意一个收货地址：看其是否有其他地址可用
    String queryMo(String rid);//通过rid查询此地址是否为默认收货地址
    void setMo(String rid);//随便选一个其他作为默认收货地址
    void deleteByRid(String rid);//通过rid删除此收货地址

    Address getMoByUid(String uid);
}