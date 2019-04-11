package hx.insist.pojo;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fitting {
    private String fid;

    private String fname;

    private String ftype;

    private String fstyle;

    private BigDecimal fprice;

    private String fimg;

    private String fintro;

    private Integer fsvolume;

    private Integer fsign;

    private Map<String,String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public boolean Verification(){
        boolean isOK = true;

        if(fname==null || StringUtils.isEmpty(fname)){//空
            isOK = false;
            errors.put("fname","名字必填!");
        }else{//非空
            if(fname.length()>32){
                isOK = false;
                errors.put("fname","名字太长!最高长度为32个字符。");
            }
        }

        if(fprice==null || StringUtils.isEmpty(fprice)){//空
            isOK = false;
            errors.put("fprice","价格必填!");
        }

        return isOK;
    }

    public Fitting() {
    }

    public Fitting(String fid, String fname, String ftype, String fstyle, BigDecimal fprice, String fimg, String fintro, Integer fsvolume, Integer fsign) {
        this.fid = fid;
        this.fname = fname;
        this.ftype = ftype;
        this.fstyle = fstyle;
        this.fprice = fprice;
        this.fimg = fimg;
        this.fintro = fintro;
        this.fsvolume = fsvolume;
        this.fsign = fsign;
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

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFstyle() {
        return fstyle;
    }

    public void setFstyle(String fstyle) {
        this.fstyle = fstyle == null ? null : fstyle.trim();
    }

    public BigDecimal getFprice() {
        return fprice;
    }

    public void setFprice(BigDecimal fprice) {
        this.fprice = fprice;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg == null ? null : fimg.trim();
    }

    public String getFintro() {
        return fintro;
    }

    public void setFintro(String fintro) {
        this.fintro = fintro == null ? null : fintro.trim();
    }

    public Integer getFsvolume() {
        return fsvolume;
    }

    public void setFsvolume(Integer fsvolume) {
        this.fsvolume = fsvolume;
    }

    public Integer getFsign() {
        return fsign;
    }

    public void setFsign(Integer fsign) {
        this.fsign = fsign;
    }

    @Override
    public String toString() {
        return "Fitting{" +
                "fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", ftype='" + ftype + '\'' +
                ", fstyle='" + fstyle + '\'' +
                ", fprice=" + fprice +
                ", fimg='" + fimg + '\'' +
                ", fintro='" + fintro + '\'' +
                ", fsvolume=" + fsvolume +
                ", fsign=" + fsign +
                '}';
    }
}