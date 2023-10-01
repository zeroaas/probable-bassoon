package com.example.tiles.mapper;


import com.example.tiles.pojo.Emp;
import com.example.tiles.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    Long count();

    List<Emp> list(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void upDate(Emp emp);

    void deleteByDeptId(Integer id);

    public Emp getByUsernameAndPassword(Emp emp);
}
