package hx.insist.service;

import hx.insist.mapper.AddressMapper;
import hx.insist.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void add(Address address) {
        address.setRid(UUID.randomUUID().toString());
        addressMapper.insert(address);
    }

    @Override
    public List<Address> getAllByUid(String uid) {
        List<Address> list = addressMapper.selectAllByUid(uid);
        return list;
    }

    @Override
    public void updateMo(String uid) {
        String rid = addressMapper.selectMo(uid);
        if(rid!=null && rid.length()!=0){//存在默认地址
            //将其设置为非默认
            addressMapper.set0Mo(rid);
        }
        //不存在默认地址就什么都不做
    }

    @Override
    public int getCountMo(String uid) {
        return addressMapper.selectCountMo(uid);
    }

    @Override
    public void deleteByRid(String rid) {
        addressMapper.deleteByRid(rid);
    }

    @Override
    public Address getMoByUid(String uid) {
        return addressMapper.selectMoAddress(uid);
    }

    @Override
    public Address getOtherByUid(String uid,String rid) {
        Address address = addressMapper.selectOtherByUid(uid,rid);
        return address;
    }

    @Override
    public String queryMo(String rid) {
        String s = addressMapper.queryMo(rid);
        return s;
    }

    @Override
    public void setMo(String rid) {
        addressMapper.set1Mo(rid);
    }
}
