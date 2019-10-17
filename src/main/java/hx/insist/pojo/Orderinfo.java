package hx.insist.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class Orderinfo {
    private String ofid;

    private String ofserial;

    private String uid;

    private String rid;

    private String rname;

    private String rtel;

    private String ofaddress;

    private BigDecimal ofprice;

    private Date oftime;

    private String stroftime;

    private String ofstate;

    public String getOfid() {
        return ofid;
    }

    public void setOfid(String ofid) {
        this.ofid = ofid == null ? null : ofid.trim();
    }

    public String getOfserial() {
        return ofserial;
    }

    public void setOfserial(String ofserial) {
        this.ofserial = ofserial == null ? null : ofserial.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel == null ? null : rtel.trim();
    }

    public String getOfaddress() {
        return ofaddress;
    }

    public void setOfaddress(String ofaddress) {
        this.ofaddress = ofaddress == null ? null : ofaddress.trim();
    }

    public BigDecimal getOfprice() {
        return ofprice;
    }

    public void setOfprice(BigDecimal ofprice) {
        this.ofprice = ofprice;
    }

    public Date getOftime() {
        return oftime;
    }

    public void setOftime(Date oftime) {
        this.oftime = oftime;
    }

    public String getStroftime() {
        return stroftime;
    }

    public void setStroftime(String stroftime) {
        this.stroftime = stroftime;
    }

    public String getOfstate() {
        return ofstate;
    }

    public void setOfstate(String ofstate) {
        this.ofstate = ofstate == null ? null : ofstate.trim();
    }

    @Override
    public String toString() {
        return "Orderinfo{" +
                "ofid='" + ofid + '\'' +
                ", ofserial='" + ofserial + '\'' +
                ", uid='" + uid + '\'' +
                ", rid='" + rid + '\'' +
                ", rname='" + rname + '\'' +
                ", rtel='" + rtel + '\'' +
                ", ofaddress='" + ofaddress + '\'' +
                ", ofprice=" + ofprice +
                ", oftime=" + oftime +
                ", stroftime='" + stroftime + '\'' +
                ", ofstate='" + ofstate + '\'' +
                '}';
    }
}