package hx.insist.service;

import java.util.List;

public interface StyleService {
    List findAllStyle();
    void delStyleBySid(String sid);
}
