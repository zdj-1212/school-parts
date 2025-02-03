package cn.cslg.service.impl;

import cn.cslg.mapper.PartsMapper;
import cn.cslg.model.Parts;
import cn.cslg.service.PartsService;
import cn.cslg.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PartsServiceImpl implements PartsService {
    @Override
    public int savePart(Parts part) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        int row=mapper.insert(part);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int deleteById(Integer id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        int row=mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }



    @Override
    public List<Parts> showList() {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        List<Parts> list=mapper.select();
        sqlSession.close();
        return list;
    }

    @Override
    public Parts getById(Integer id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        Parts part=mapper.selectById(id);
        sqlSession.close();
        return part;
    }
    @Override
    public List<Parts> showListByName(String name) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        List<Parts> list=mapper.selectByName(name);
        sqlSession.close();
        return list;
    }
    @Override
    public int updateByid(Parts part) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartsMapper mapper=sqlSession.getMapper(PartsMapper.class);
        mapper.update(part);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}
