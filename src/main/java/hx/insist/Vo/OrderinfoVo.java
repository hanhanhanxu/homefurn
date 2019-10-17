package hx.insist.Vo;

import hx.insist.pojo.Orderinfo;
import hx.insist.pojo.Orderitems;
import lombok.Data;

import java.util.List;

@Data
public class OrderinfoVo {
    /**
     * 装饰名 总价 收货人 电话 地址 下单时间 订单状态 订单号
     * 订单详情: 家居图片 名字 价格
     */
    private String sname;//装饰名字
    private Orderinfo orderinfo;//订单信息
    private List<OrderitemsVo> orderitemsVoList;//订单详情  都买了啥
    private List<Orderitems> orderitemsList;
}
