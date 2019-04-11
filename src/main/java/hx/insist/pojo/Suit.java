package hx.insist.pojo;

import java.math.BigDecimal;

public class Suit {
    private String sid;

    private String uid;

    private String sname;

    private BigDecimal sprice;

    private Integer ssign;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public Integer getSsign() {
        return ssign;
    }

    public void setSsign(Integer ssign) {
        this.ssign = ssign;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "sid='" + sid + '\'' +
                ", uid='" + uid + '\'' +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", ssign=" + ssign +
                '}';
    }
}