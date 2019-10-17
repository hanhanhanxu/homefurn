package hx.insist.service;

import hx.insist.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List findAllType() {
        List list = typeMapper.selectAll();
        if(list.isEmpty())
            return null;
        else
            return list;
    }

    @Override
    public void delTypeByTid(String tid) {
        typeMapper.deleteByPrimaryKey(tid);
    }
}
