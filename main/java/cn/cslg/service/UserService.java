package cn.cslg.service;

import cn.cslg.model.User;

import java.util.List;

public interface UserService {
    int saveUser(User user);
    int saveUser1(User user);
    int deleteByid(String id);
    int deleteByid1(String id);
    List<User> showlist();
    List<User>  showlist2(String id);
    List<User> showlist1();
    User getByid(String id);
    User getByid1(String id);
    int updateByid(User user);
    int updateByid1(User user);
}
