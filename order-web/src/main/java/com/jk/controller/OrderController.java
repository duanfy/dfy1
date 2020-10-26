package com.jk.controller;

import com.jk.entity.OrderBean;
import com.jk.service.OrderService;
import com.jk.utils.PageResult;
import com.jk.utils.RedisContent;
import com.jk.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("show")
    public String show(){
        return "showorder";
    }


    @RequestMapping("select")
    @ResponseBody
    public List<OrderBean> select(){
        return orderService.select();
    }


    @RequestMapping("insert")
    @ResponseBody
    public void insert(OrderBean order){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        orderService.insert(order);
    }


    @RequestMapping("del")
    @ResponseBody
    public void del(String[] orderId){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        orderService.del(orderId);
    }


    @RequestMapping("huix")
    @ResponseBody
    public OrderBean huix(Integer orderId){
        return orderService.huix(orderId);
    }


    @RequestMapping("xiu")
    @ResponseBody
    public void xiu(Integer orderId){
        redisUtil.del(RedisContent.USER_LIST_KEY);
        orderService.xiu(orderId);
    }
}
