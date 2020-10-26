package com.jk.service;

import com.jk.entity.UserBean;
import com.jk.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-provider")
public interface UserService {

    /*@RequestMapping("show")
    String show();*/

    @RequestMapping("select")
    public PageResult select(@RequestParam Integer currPage, @RequestParam Integer pageSize);

    @RequestMapping("insert")
    public void insert(@RequestBody UserBean user);

    @RequestMapping("del")
    public void del(@RequestParam String[] userId);

    @RequestMapping("huix")
    public UserBean huix(@RequestParam Integer userId);

    @RequestMapping("xiu")
    public void xiu(@RequestParam Integer userId);
}
