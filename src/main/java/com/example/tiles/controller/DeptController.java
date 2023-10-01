package com.example.tiles.controller;

import com.example.tiles.pojo.Dept;
import com.example.tiles.pojo.Result;
import com.example.tiles.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result list(){
        log.info("查询所有部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除元素id为"+id+"的元素");
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.insert(dept);
        return Result.success();
    }

    @PutMapping
    public Result upDate(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }

}