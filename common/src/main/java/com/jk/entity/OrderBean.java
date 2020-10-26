package com.jk.entity;

import lombok.Data;

@Data
public class OrderBean {
    private Integer orderId;
    private String orderName;
    private String orderNumber;
    private Integer orderPrice;
    private String orderCreatetime;
    private Integer orderMethod;

    private String methodName;
}
