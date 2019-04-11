package hx.insist.pojo;

import java.math.BigDecimal;

public class Orderitem {
    private String oiid;

    private String oid;

    private String fid;

    private String fname;

    private BigDecimal fprice;

    public String getOiid() {
        return oiid;
    }

    public void setOiid(String oiid) {
        this.oiid = oiid == null ? null : oiid.trim();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
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
        return "Orderitem{" +
                "oiid='" + oiid + '\'' +
                ", oid='" + oid + '\'' +
                ", fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", fprice=" + fprice +
                '}';
    }
}