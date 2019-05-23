package hx.insist.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hx.insist.Vo.FittingDetail;
import hx.insist.dao.FittingDao;
import hx.insist.mapper.FittingMapper;
import hx.insist.pojo.Fitting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FittingServiceImpl implements FittingService {

    @Autowired
    private FittingMapper fittingMapper;
    @Autowired
    private FittingDao fittingDao;

    @Override
    public PageInfo<Fitting> fingAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        //PageHelper.startPage 的下一个查询将会是分页查询。
        List<Fitting> list = fittingMapper.selectAll();
        PageInfo<Fitting> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Fitting> fingByCondition(int currentPage, int pageSize, String type, String style) {
        PageHelper.startPage(currentPage, pageSize);
        List list = fittingMapper.fingByCondition(type,style);
        PageInfo<Fitting> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Fitting> fingByFtype(int currentPage, int pageSize, String type) {
        PageHelper.startPage(currentPage, pageSize);
        List list = fittingMapper.fingByFtype(type);
        PageInfo<Fitting> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Fitting> fingByFstyle(int currentPage, int pageSize, String style) {
        PageHelper.startPage(currentPage, pageSize);
        List list = fittingMapper.fingByFstyle(style);
        PageInfo<Fitting> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override               //solr查询   调用fittingdao
    public PageInfo<Fitting> findOverall(int currentPage, int pageSize, String str) {
        PageHelper.startPage(currentPage, pageSize);
        List list = fittingDao.queryOverall(str);
        PageInfo<Fitting> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public FittingDetail queryDetailsByFid(String fid) {
        return fittingMapper.connSelectByFid(fid);
        //return fittingMapper.selectByPrimaryKey(fid);
    }

    @Override
    public void addFsvolume(String fid) {
        fittingMapper.updateFsvolumeBySid(fid);
    }

    @Override
    public List selectForRank() {
        List list = fittingMapper.selectForRank();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public List findByFname(String fname) {
        List list = fittingMapper.selectByFname(fname);
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public List findTop(int num) {
        List list = fittingMapper.selectTop(num);
        return list;
    }

    @Override
    public String getFimgByFid(String fid) {
        return fittingMapper.selectFimgByFid(fid);
    }

    @Override
    public void xiajiaFitting(String fid) {
        fittingMapper.updateFsignByFid(fid);
    }
}
