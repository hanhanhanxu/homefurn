package hx.insist.pojo;

public class FittingStock {
    private String fsid;

    private String fid;

    private Integer fsnum;

    private String fname;

    public String getFsid() {
        return fsid;
    }

    public void setFsid(String fsid) {
        this.fsid = fsid == null ? null : fsid.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Integer getFsnum() {
        return fsnum;
    }

    public void setFsnum(Integer fsnum) {
        this.fsnum = fsnum;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }
}