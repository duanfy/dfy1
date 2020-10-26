package com.jk.service;

import com.jk.entity.OrderBean;
import com.jk.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderService {
   /* PageResult select(@RequestParam Integer currPage, @RequestParam Integer pageSize);*/

    void insert(@RequestBody OrderBean order);

    void del(@RequestParam String[] orderId);

    OrderBean huix(@RequestParam Integer orderId);

    void xiu(@RequestParam Integer orderId);

    List<OrderBean> selects();
}
