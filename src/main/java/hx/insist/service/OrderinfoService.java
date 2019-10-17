package hx.insist.service;

import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderinfoVo;
import hx.insist.pojo.Orderinfo;

import java.util.List;

public interface OrderinfoService {
    void addOrder(String sid);
    List<Orderinfo> getAllByUid(String uid);
    List<Orderinfo> getAllByUidAndOfstate(String uid,String string);

    PageInfo<OrderinfoVo> getAll(int currentPage, int pageSize);
    PageInfo<OrderinfoVo> getAllByOfstate(int currentPage, int pageSize,String string);

    void orderByOfid(String ofid);//待收货 已发货
    void receiveByOfid(String ofid);//已发货 已收获
}
