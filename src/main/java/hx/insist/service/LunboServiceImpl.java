package hx.insist.service;

import hx.insist.mapper.LunboMapper;
import hx.insist.pojo.Lunbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LunboServiceImpl implements LunboService {

    @Autowired
    private LunboMapper lunboMapper;

    @Override
    public void add(Lunbo lunbo) {
        lunbo.setLid(UUID.randomUUID().toString());
        lunbo.setFid(null);
        lunboMapper.insertSelective(lunbo);
    }

    @Override
    public void del(String lid) {
        lunboMapper.deleteByLid(lid);
    }

    @Override
    public List selectAll() {
        List list = lunboMapper.selectAll();
        return list;
    }

    @Override
    public String selectHouzhui(String lid) {
        return lunboMapper.selectHouzhuiByLid(lid);
    }
}
