package hx.insist.service;

import hx.insist.mapper.*;
import hx.insist.pojo.*;
import hx.insist.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private StyleMapper styleMapper;
    @Autowired
    private FittingMapper fittingMapper;
    @Autowired
    private FittingStockMapper fittingStockMapper;

    @Override
    public void generateAdmin(String username,String password) {
        Admin admin = new Admin(UUID.randomUUID().toString(),username, WebUtil.md5(password));
        adminMapper.insert(admin);
    }

    @Override
    public Admin login(String username, String password) {
        return adminMapper.selectByUsernamePassword(username,password);
    }

    @Override
    public int countAdminByUsername(String username) {
        return adminMapper.selectCountByUsername(username);
    }

    @Override
    public int addType(String typeName) {
        System.out.println("adminservice层，typeName:"+typeName);
        //通过此名称查询有几条记录
        int n = typeMapper.selectByTname(typeName);
        //没有重名的种类
        if(n==0){
            //添加家居种类
            Type type = new Type();
            type.setTid(UUID.randomUUID().toString());
            type.setTname(typeName);
            typeMapper.insert(type);
            return 0;
        }else{
            return n;
        }
    }

    @Override
    public int addStyle(String styleName) {
        //通过此名称查询有几条记录
        int n = styleMapper.selectByTname(styleName);
        //没有重名的风格
        if(n==0){
            //添加家居风格
            Style style = new Style();
            style.setSid(UUID.randomUUID().toString());
            style.setSname(styleName);
            styleMapper.insert(style);
            return 0;
        }else{
            return n;
        }
    }

    @Override
    public void addFitting(Fitting fitting,int fsnum) {
        fitting.setFid(UUID.randomUUID().toString());
        fitting.setFsvolume(0);
        fitting.setFsign(1);
        fittingMapper.insert(fitting);
        FittingStock fittingStock = new FittingStock();
        fittingStock.setFsid(UUID.randomUUID().toString());
        fittingStock.setFid(fitting.getFid());
        fittingStock.setFsnum(fsnum);
        fittingStockMapper.insert(fittingStock);
    }
}
