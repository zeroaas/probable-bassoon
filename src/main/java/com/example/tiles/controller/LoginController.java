package com.example.tiles.controller;

import com.example.tiles.pojo.Emp;
import com.example.tiles.pojo.Result;
import com.example.tiles.service.EmpService;
import com.example.tiles.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：");
        Emp e = empService.login(emp);

        //登录成功，生成并下发令牌
        if (e!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");

    }
}
