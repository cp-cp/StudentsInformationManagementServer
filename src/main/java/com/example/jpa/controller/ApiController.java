package com.example.jpa.controller;


import com.example.jpa.bean.User;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/init")
    public String init(){
        User user = null;
        for(int i=0;i<10;i++){
            user = new User();
            user.setName("test"+i);
            userService.save(user);
        }
        return "初始化完成。";
    }

    @GetMapping("/userByName/{username}")
    public User getUserByName(@PathVariable("username") String username){
        return userService.getByName(username);
    }

    @GetMapping("/userById/{userid}")
    public User getUserById(@PathVariable("userid") Long userid){
        return userService.getUserByID(userid);
    }

    @GetMapping("/page")
    public Page<User> getPage(){
        return userService.findPage();
    }

    @GetMapping("/page/{maxID}")
    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID){
        return userService.find(maxID);
    }

    @RequestMapping("/update/{id}/{name}")
    public User update(@PathVariable Long id, @PathVariable String name){
        return userService.update(id,name);
    }

    @RequestMapping("/update/{id}")
    public Boolean updateById(@PathVariable Long id){
        return userService.updateById("newName",id);
    }
}