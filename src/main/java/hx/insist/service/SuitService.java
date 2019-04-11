package hx.insist.service;

import hx.insist.pojo.Suit;

import java.util.List;

public interface SuitService {
    List QueryAllByUid(String uid);
    List QueryAllByUidOrdered(String uid);
    Suit selectBySid(String sid);
    void addSuit(Suit suit);
    void delSuit(String sid);
    void updateSsign(String sid);
}
