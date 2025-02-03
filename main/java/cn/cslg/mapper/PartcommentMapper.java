package cn.cslg.mapper;

import cn.cslg.model.Partcomment;

import java.util.List;

public interface PartcommentMapper {
    List<Partcomment> select();
    int insert(Partcomment partcomment);
    int delete(Integer id);
    int delete1(Integer id);
    int update(Partcomment partcomment);
    List<Partcomment> selectById(Integer id);

}
