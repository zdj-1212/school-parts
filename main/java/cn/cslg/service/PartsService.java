package cn.cslg.service;

import cn.cslg.model.Parts;

import java.util.List;

public interface PartsService {
    int savePart(Parts part);
    int deleteById(Integer id);
    List<Parts> showList();
    Parts getById(Integer id);
    List<Parts> showListByName(String name);
    int updateByid(Parts part);

}
