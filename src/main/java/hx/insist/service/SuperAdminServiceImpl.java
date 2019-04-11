package hx.insist.service;


import hx.insist.mapper.SuperadminMapper;
import hx.insist.pojo.Superadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

    @Autowired
    private SuperadminMapper superadminMapper;

    @Override
    public Superadmin login(String username, String password) {
        return superadminMapper.selectByUsernamePassword(username,password);
    }
}
