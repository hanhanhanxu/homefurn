package hx.insist.service;

import hx.insist.pojo.Lunbo;

import java.util.List;

public interface LunboService {
    void add(Lunbo lunbo);
    void del(String lid);
    List selectAll();
    String selectHouzhui(String lid);
}
