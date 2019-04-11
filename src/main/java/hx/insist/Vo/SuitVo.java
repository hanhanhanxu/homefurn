package hx.insist.Vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SuitVo {
    private String sid;
    //private String uid;
    private String sname;
    private BigDecimal sprice;
    private List<CollocationVo> collocations;
}
