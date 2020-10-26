package com.jk.entity;

import lombok.Data;

@Data
public class UserBean {
    private Integer userId;
    private String userName;
    private Integer userDeptid;
    private String userEntrytime;
    private String userPost;
    private String userDuty;

    private String deptName;
}
