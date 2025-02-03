package cn.cslg.mapper;

import cn.cslg.model.Parts;

import java.util.List;

public interface PartsMapper {
    List<Parts> select();
    int insert(Parts parts);
    int delete(Integer id );
    int update(Parts parts);
    Parts selectById(Integer id);
    List<Parts> selectByName(String name);
}
