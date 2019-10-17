package hx.insist.pojo;

public class Address {
    private String rid;

    private String uid;

    private String rname;

    private String rtel;

    private String rpro;

    private String rcity;

    private String rarea;

    private String rinfo;

    private Integer rmo;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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

    public String getRpro() {
        return rpro;
    }

    public void setRpro(String rpro) {
        this.rpro = rpro == null ? null : rpro.trim();
    }

    public String getRcity() {
        return rcity;
    }

    public void setRcity(String rcity) {
        this.rcity = rcity == null ? null : rcity.trim();
    }

    public String getRarea() {
        return rarea;
    }

    public void setRarea(String rarea) {
        this.rarea = rarea == null ? null : rarea.trim();
    }

    public String getRinfo() {
        return rinfo;
    }

    public void setRinfo(String rinfo) {
        this.rinfo = rinfo == null ? null : rinfo.trim();
    }

    public Integer getRmo() {
        return rmo;
    }

    public void setRmo(Integer rmo) {
        this.rmo = rmo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "rid='" + rid + '\'' +
                ", uid='" + uid + '\'' +
                ", rname='" + rname + '\'' +
                ", rtel='" + rtel + '\'' +
                ", rpro='" + rpro + '\'' +
                ", rcity='" + rcity + '\'' +
                ", rarea='" + rarea + '\'' +
                ", rinfo='" + rinfo + '\'' +
                ", rmo=" + rmo +
                '}';
    }
}