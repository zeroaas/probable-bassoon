package com.example.tiles.service.impl;

import com.example.tiles.mapper.EmpMapper;
import com.example.tiles.pojo.Dept;
import com.example.tiles.pojo.Emp;
import com.example.tiles.pojo.PageBean;
import com.example.tiles.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpSerrviceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        Long count = empMapper.count();

        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize,name,gender,begin,end);

        PageBean pageBean = new PageBean(count , empList);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp getById(Integer id) {

        return empMapper.getById(id);
    }

    @Override
    public void upDate(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.upDate(emp);
    }

    @Override
    public Emp login(Emp emp) {
        //调用dao层功能：登录
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);

        //返回查询结果给Controller
        return loginEmp;
    }

}
