package hx.insist.Vo;

import hx.insist.pojo.Orderitem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderVo {
    private String oid;
    private String uid;
    private String username;
    private String otime;
    private BigDecimal oprice;
    private List<Orderitem> orderitems;
}
