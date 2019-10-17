package hx.insist.service;

import hx.insist.mapper.OrderitemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderitemsServiceImpl implements OrderitemsService {
    @Autowired
    private OrderitemsMapper orderitemsMapper;

    @Override
    public List getAllOrderinfoByOfid(String ofid) {
        List list = orderitemsMapper.selectAllByOfid(ofid);
        if (list.isEmpty())
            return null;
        return list;
    }
}
