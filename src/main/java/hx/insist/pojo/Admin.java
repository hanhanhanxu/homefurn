package hx.insist.pojo;

public class Admin {
    private String aid;

    private String ausername;

    private String apassword;

    public Admin() {
    }

    public Admin(String aid, String ausername, String apassword) {
        this.aid = aid;
        this.ausername = ausername;
        this.apassword = apassword;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    public String getAusername() {
        return ausername;
    }

    public void setAusername(String ausername) {
        this.ausername = ausername == null ? null : ausername.trim();
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword == null ? null : apassword.trim();
    }
}