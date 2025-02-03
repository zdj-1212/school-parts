package cn.cslg.service;

import cn.cslg.model.Partcomment;

import java.util.List;

public interface PartcommentService {
    int savePartcomment(Partcomment partcomment);
    int deleteByid(Integer id);
    int deleteBybid(Integer bid);
    List<Partcomment> showList();
    List<Partcomment> getByid(Integer id);
    int updateById(Partcomment partcomment);
}
