package com.example.tiles.service;

import com.example.tiles.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查找全部部门
    List<Dept> list();

    //按id删除
    void deleteById(Integer id);

    //新增
    void insert(Dept dept);

    //编辑
    void update(Dept dept);
}
