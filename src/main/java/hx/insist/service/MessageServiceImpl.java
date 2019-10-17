package hx.insist.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hx.insist.mapper.MessageMapper;
import hx.insist.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public void insert(hx.insist.pojo.Message message) {
        message.setMid(UUID.randomUUID().toString());
        message.setMtime(new Date());
        messageMapper.insert(message);
    }

    @Override
    public void delete(String mid) {
        messageMapper.deleteByMid(mid);
    }

    @Override
    public PageInfo<Message> select(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Message> list = messageMapper.select();
        for(Message m:list){
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            m.setStime(format.format(m.getMtime()));
        }
        PageInfo<Message> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
