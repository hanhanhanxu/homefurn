package hx.insist.service;

import hx.insist.pojo.Collocation;

import java.util.List;

public interface CollocationService {
    void addCollocation(Collocation collocation);
    void delCollocation(String cid);
    List findCollocationBySid(String sid);
}
