package hx.insist.service;

import hx.insist.pojo.Admin;
import hx.insist.pojo.Fitting;

public interface AdminService {
    void generateAdmin(String username,String password);
    Admin login(String username, String password);
    int countAdminByUsername(String username);

    int addType(String typeName);
    int addStyle(String styleName);

    void addFitting(Fitting fitting,int fsnum);

}
