package com.jk.service.impl;

import com.jk.dao.UserBeanMapper;
import com.jk.entity.UserBean;
import com.jk.service.UserService;
import com.jk.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    public PageResult select(@RequestParam Integer currPage,@RequestParam Integer pageSize) {
        Long total = userBeanMapper.count();
        List<UserBean> naviglist = userBeanMapper.findPage(currPage, pageSize);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, naviglist, currPage, pageSize, totalPage);
    }

    @Override
    public void insert(UserBean user) {
        if (user.getUserId()==null){
            userBeanMapper.insert(user);
        }else{
            userBeanMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public void del(@RequestParam String[] userId) {
        userBeanMapper.del(userId);
    }

    @Override
    public UserBean huix(@RequestParam Integer userId) {
        return userBeanMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void xiu(@RequestParam Integer userId) {
        userBeanMapper.xiu(userId);
    }
}
