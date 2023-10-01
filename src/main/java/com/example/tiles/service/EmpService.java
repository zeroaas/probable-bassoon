package com.example.tiles.service;

import com.example.tiles.pojo.Dept;
import com.example.tiles.pojo.Emp;
import com.example.tiles.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void upDate(Emp emp);

    public Emp login(Emp emp);

}
