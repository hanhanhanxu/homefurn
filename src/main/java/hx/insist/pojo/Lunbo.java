package hx.insist.pojo;

public class Lunbo {
    private String lid;

    private Integer lnum;

    private String lpic;

    private String fid;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid == null ? null : lid.trim();
    }

    public Integer getLnum() {
        return lnum;
    }

    public void setLnum(Integer lnum) {
        this.lnum = lnum;
    }

    public String getLpic() {
        return lpic;
    }

    public void setLpic(String lpic) {
        this.lpic = lpic == null ? null : lpic.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    @Override
    public String toString() {
        return "Lunbo{" +
                "lid='" + lid + '\'' +
                ", lnum=" + lnum +
                ", lpic='" + lpic + '\'' +
                ", fid='" + fid + '\'' +
                '}';
    }
}