package com.example.kotlinserver.service;

import com.example.kotlinserver.model.UserInfo;

public interface UserService {
    UserInfo getUserById(int paramInt);

    UserInfo getUserByMobile(String mobile);

    void addUser(UserInfo paramUserInfo);

    int modifyUser(UserInfo paramUserInfo);
}
