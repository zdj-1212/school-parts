package cn.cslg.service.impl;

import cn.cslg.mapper.UserMapper;
import cn.cslg.model.User;
import cn.cslg.service.UserService;
import cn.cslg.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public int saveUser(User user) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int i=mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int saveUser1(User user) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int i=mapper.insert1(user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
    @Override
    public int deleteByid(String id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int i=mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
    @Override
    public int deleteByid1(String id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int i=mapper.delete1(id);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
    @Override
    public List<User> showlist() {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=mapper.select();
        sqlSession.close();
        return userList;
    }
    @Override
    public List<User> showlist1() {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=mapper.select1();
        sqlSession.close();
        return userList;
    }
    @Override
    public List<User> showlist2(String id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=mapper.select2(id);
        sqlSession.close();
        return userList;
    }
    @Override
    public User getByid(String id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.selectById(id);
        //关闭资源
        sqlSession.close();
        return user;
    }
    @Override
    public User getByid1(String id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.selectById1(id);
        //关闭资源
        sqlSession.close();
        return user;
    }

    @Override
    public int updateByid(User user) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.update(user);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
    @Override
    public int updateByid1(User user) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.update1(user);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}
