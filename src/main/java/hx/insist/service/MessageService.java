package hx.insist.service;

import com.github.pagehelper.PageInfo;
import hx.insist.pojo.Message;

public interface MessageService {
    void insert(Message message);
    void delete(String mid);
    PageInfo<Message> select(int currentPage, int pageSize);
}
