package cn.cslg.mapper;

import cn.cslg.model.User;

import java.util.List;

public interface UserMapper {
    List<User> select();
    List<User> select1();
    List<User> select2(String id);
    int insert(User user);
    int insert1(User user);
    int delete(String id);
    int delete1(String id);
    int update(User user);
    int update1(User user);
    User selectById(String id);
    User selectById1(String id);
}
