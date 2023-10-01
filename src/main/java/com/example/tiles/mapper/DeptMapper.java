package com.example.tiles.mapper;

import com.example.tiles.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询所有部门数据
    List<Dept> list();

    //id删除
    void deleteById(Integer id);

    //增加部门
    void inser(Dept dept);

    void update(Dept dept);
}
