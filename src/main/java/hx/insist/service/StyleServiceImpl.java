package hx.insist.service;

import hx.insist.mapper.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleMapper styleMapper;

    @Override
    public List findAllStyle() {
        List list = styleMapper.selectAll();
        if(list.isEmpty())
            return null;
        else
            return list;
    }

    @Override
    public void delStyleBySid(String sid) {
        styleMapper.deleteByPrimaryKey(sid);
    }
}
