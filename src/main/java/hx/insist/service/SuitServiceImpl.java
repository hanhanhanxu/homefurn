package hx.insist.service;

import hx.insist.mapper.SuitMapper;
import hx.insist.pojo.Suit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SuitServiceImpl implements SuitService {

    @Autowired
    private SuitMapper suitMapper;

    @Override
    public List QueryAllByUid(String uid) {
        List list = suitMapper.findAllByUid(uid);
        if(list==null || list.isEmpty())
            return null;
        return list;
    }

    @Override
    public List QueryAllByUidOrdered(String uid) {
        List list = suitMapper.findAllByUidOrdered(uid);
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public Suit selectBySid(String sid) {
        return suitMapper.selectByPrimaryKey(sid);
    }

    @Override
    public void addSuit(Suit suit) {
        suit.setSid(UUID.randomUUID().toString());
        suit.setSprice(new BigDecimal(0));
        suit.setSsign(0);
        suitMapper.insert(suit);
    }

    @Override
    public void delSuit(String sid) {
        suitMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public void updateSsign(String sid) {
        suitMapper.updateSsign(sid);
    }
}
