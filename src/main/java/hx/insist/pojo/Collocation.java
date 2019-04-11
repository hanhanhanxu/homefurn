package hx.insist.pojo;

import java.math.BigDecimal;

public class Collocation {
    private String cid;

    private String sid;

    private String fid;

    private String fname;

    private BigDecimal fprice;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
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

    @Override
    public String toString() {
        return "Collocation{" +
                "cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", fprice=" + fprice +
                '}';
    }
}