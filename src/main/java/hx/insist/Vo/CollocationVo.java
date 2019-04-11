package hx.insist.Vo;

import lombok.Data;

import java.math.BigDecimal;

//collocation加上一个fimg
@Data
public class CollocationVo {
    private String cid;
    private String sid;
    private String fid;
    private String fname;
    private String fimg;
    private BigDecimal fprice;
}
