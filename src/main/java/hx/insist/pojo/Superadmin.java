package hx.insist.pojo;

public class Superadmin {
    private String said;

    private String saname;

    private String sapass;

    public String getSaid() {
        return said;
    }

    public void setSaid(String said) {
        this.said = said == null ? null : said.trim();
    }

    public String getSaname() {
        return saname;
    }

    public void setSaname(String saname) {
        this.saname = saname == null ? null : saname.trim();
    }

    public String getSapass() {
        return sapass;
    }

    public void setSapass(String sapass) {
        this.sapass = sapass == null ? null : sapass.trim();
    }
}