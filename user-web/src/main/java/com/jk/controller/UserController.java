package com.jk.controller;

import com.jk.entity.UserBean;
import com.jk.service.UserService;
import com.jk.utils.PageResult;
import com.jk.utils.RedisContent;
import com.jk.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    /*@RequestMapping("show")
    private String show(){
        return userService.show();
    }*/


    @RequestMapping("index")
    public String index(){
        return "show";
    }


    @RequestMapping("select")
    @ResponseBody
    public PageResult select(Integer currPage, Integer pageSize){
        PageResult chaxun = (PageResult) redisUtil.get(RedisContent.USER_LIST_KEY);
        if (chaxun == null){
            PageResult select = userService.select(currPage, pageSize);
            chaxun=select;
            redisUtil.set(RedisContent.USER_LIST_KEY, select);
            redisUtil.expire(RedisContent.USER_LIST_KEY, 60);
        }
        return chaxun;
    }


    @RequestMapping("insert")
    @ResponseBody
    public void insert(UserBean user){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        userService.insert(user);
    }


    @RequestMapping("del")
    @ResponseBody
    public void del(String[] userId){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        userService.del(userId);
    }


    @RequestMapping("huix")
    @ResponseBody
    public UserBean huix(Integer userId){
        return userService.huix(userId);
    }


    @RequestMapping("xiu")
    @ResponseBody
    public void xiu(Integer userId){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        userService.xiu(userId);
    }
}
