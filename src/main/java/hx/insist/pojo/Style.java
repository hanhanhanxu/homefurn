package hx.insist.pojo;

public class Style {
    private String sid;

    private String sname;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    @Override
    public String toString() {
        return "Style{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}