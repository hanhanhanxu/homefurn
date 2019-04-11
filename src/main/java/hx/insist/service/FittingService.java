package hx.insist.service;

import com.github.pagehelper.PageInfo;
import hx.insist.pojo.Fitting;

import java.util.List;

public interface FittingService {

    PageInfo<Fitting> fingAll(int currentPage, int pageSize);
    PageInfo<Fitting> fingByCondition(int currentPage, int pageSize,String type,String style);
    PageInfo<Fitting> fingByFtype(int currentPage, int pageSize,String type);
    PageInfo<Fitting> fingByFstyle(int currentPage, int pageSize,String style);

    PageInfo<Fitting> findOverall(int currentPage, int pageSize,String str);

    Fitting queryDetailsByFid(String fid);

    void addFsvolume(String fid);

    List selectForRank();
}
