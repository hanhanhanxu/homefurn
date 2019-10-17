package hx.insist.pojo;

import java.math.BigDecimal;

public class Orderitems {
    private String osid;

    private String ofid;

    private String fid;

    private String fname;

    private BigDecimal fprice;

    private Integer fnum;

    private BigDecimal fpay;

    public String getOsid() {
        return osid;
    }

    public void setOsid(String osid) {
        this.osid = osid == null ? null : osid.trim();
    }

    public String getOfid() {
        return ofid;
    }

    public void setOfid(String ofid) {
        this.ofid = ofid == null ? null : ofid.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public BigDecimal getFprice() {
        return fprice;
    }

    public void setFprice(BigDecimal fprice) {
        this.fprice = fprice;
    }

    public Integer getFnum() {
        return fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }

    public BigDecimal getFpay() {
        return fpay;
    }

    public void setFpay(BigDecimal fpay) {
        this.fpay = fpay;
    }
}