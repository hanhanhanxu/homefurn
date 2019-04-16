package hx.insist.service;

import hx.insist.pojo.User;

public interface UserService {
    User login(String username, String password);
    void regist(User user);
    int countUserByUsername(String username);
    int countEmail(String email);
    void modifyByUid(User user);
}
