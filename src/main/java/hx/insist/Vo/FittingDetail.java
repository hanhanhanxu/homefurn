package hx.insist.Vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FittingDetail {
    //fitting的
    private String fid;

    private String fname;

    private String ftype;

    private String fstyle;

    private BigDecimal fprice;

    private String fimg;

    private String fintro;

    private Integer fsvolume;

    private Integer fsign;
    //fitting_stock的
    private String fsid;

    //private String fid;

    private Integer fsnum;

    //private String fname;
}
