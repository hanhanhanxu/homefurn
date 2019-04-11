package hx.insist.service;

import hx.insist.pojo.User;

public interface UserService {
    public User login(String username, String password);
    public void regist(User user);
    public int countUserByUsername(String username);
}
