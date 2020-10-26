package com.jk.dao;

import com.jk.entity.OrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface OrderBeanMapper {
    int deleteByPrimaryKey(Integer orderId);

    void insert(@RequestBody OrderBean order);

    int insertSelective(OrderBean record);

    OrderBean selectByPrimaryKey(@RequestParam Integer orderId);

    void updateByPrimaryKeySelective(@RequestBody OrderBean order);

    int updateByPrimaryKey(OrderBean record);

    Long count();

    List<OrderBean> findPage(@RequestParam  Integer currPage,@RequestParam  Integer pageSize);

    void del(@RequestParam String[] userId);

    void xiu(@RequestParam Integer userId);

    List<OrderBean> selects();
}
