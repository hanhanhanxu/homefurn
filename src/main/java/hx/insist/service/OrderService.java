package hx.insist.service;

import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderVo;

import java.util.List;

public interface OrderService {
    void addOrder(String sid);
    //void addOrder(Order order);

    List findByUid(String uid);

    PageInfo<OrderVo> fingAll(int currentPage, int pageSize);
}
