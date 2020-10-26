package com.jk.service;

import com.jk.entity.OrderBean;
import com.jk.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-provider")
public interface OrderService {

    @RequestMapping("select")
    public List<OrderBean> select();

    @RequestMapping("insert")
    public void insert(@RequestBody OrderBean order);

    @RequestMapping("del")
    public void del(@RequestParam String[] orderId);

    @RequestMapping("huix")
    public OrderBean huix(@RequestParam Integer orderId);

    @RequestMapping("xiu")
    public void xiu(@RequestParam Integer orderId);
}
