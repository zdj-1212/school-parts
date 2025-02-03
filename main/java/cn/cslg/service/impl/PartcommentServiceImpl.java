package cn.cslg.service.impl;

import cn.cslg.mapper.PartcommentMapper;
import cn.cslg.model.Partcomment;
import cn.cslg.service.PartcommentService;
import cn.cslg.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PartcommentServiceImpl implements PartcommentService {
    @Override
    public int savePartcomment(Partcomment partcomment) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        int row=mapper.insert(partcomment);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int deleteByid(Integer id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        int row=mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
    @Override
    public int deleteBybid(Integer id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        int row=mapper.delete1(id);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public List<Partcomment> showList() {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        List<Partcomment> list=mapper.select();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Partcomment> getByid(Integer id) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        List<Partcomment> list=mapper.selectById(id);
        sqlSession.close();
        return list;
    }

    @Override
    public int updateById(Partcomment partcomment) {
        SqlSession sqlSession= SqlsessionUtil.getSs();
        PartcommentMapper mapper=sqlSession.getMapper(PartcommentMapper.class);
        mapper.update(partcomment);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}
