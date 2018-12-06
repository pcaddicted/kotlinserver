package com.example.kotlinserver.service.impl;

import com.example.kotlinserver.dao.UserInfoMapper;
import com.example.kotlinserver.model.UserInfo;
import com.example.kotlinserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserById(int paramInt) {
        return userInfoMapper.selectByPrimaryKey(paramInt);
    }

    @Override
    public UserInfo getUserByMobile(String paramString) {
        return userInfoMapper.selectByMobile(paramString);
    }

    @Override
    public void addUser(UserInfo paramUserInfo) {
        this.userInfoMapper.insert(paramUserInfo);
    }

    @Override
    public int modifyUser(UserInfo paramUserInfo) {
        return this.userInfoMapper.updateByPrimaryKey(paramUserInfo);
    }
}
