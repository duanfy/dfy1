package com.jk.controller;

import com.jk.entity.OrderBean;
import com.jk.service.OrderService;
import com.jk.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("select")
    @ResponseBody
    public List<OrderBean>select(){
        return orderService.selects();
    }

    @RequestMapping("insert")
    @ResponseBody
    public void insert(@RequestBody OrderBean order){
        orderService.insert(order);
    }


    @RequestMapping("del")
    @ResponseBody
    public void del(@RequestParam String[] orderId){
        orderService.del(orderId);
    }


    @RequestMapping("huix")
    @ResponseBody
    public OrderBean huix(@RequestParam Integer orderId){
        return orderService.huix(orderId);
    }


    @RequestMapping("xiu")
    public void xiu(@RequestParam Integer orderId){
        orderService.xiu(orderId);
    }
}
