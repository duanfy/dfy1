package com.jk.service.impl;

import com.jk.dao.OrderBeanMapper;
import com.jk.entity.OrderBean;
import com.jk.entity.UserBean;
import com.jk.service.OrderService;
import com.jk.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderBeanMapper orderBeanMapper;

/*    @Override
    public PageResult select(@RequestParam Integer currPage, @RequestParam Integer pageSize) {
        Long total = orderBeanMapper.count();
        List<OrderBean> naviglist = orderBeanMapper.findPage(currPage, pageSize);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, naviglist, currPage, pageSize, totalPage);
    }*/

    @Override
    public void insert(OrderBean order) {
        if (order.getOrderId() == null){
            orderBeanMapper.insert(order);
        }else{
            orderBeanMapper.updateByPrimaryKeySelective(order);
        }
    }

    @Override
    public void del(@RequestParam String[] orderId) {
        orderBeanMapper.del(orderId);
    }

    @Override
    public OrderBean huix(@RequestParam Integer orderId) {
        return orderBeanMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public void xiu(@RequestParam Integer orderId) {
        orderBeanMapper.xiu(orderId);
    }

    @Override
    public List<OrderBean> selects() {
        return orderBeanMapper.selects();
    }
}
