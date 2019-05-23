package hx.insist.service;

import java.util.List;

public interface TypeService {
    List findAllType();
    void delTypeByTid(String tid);
}
