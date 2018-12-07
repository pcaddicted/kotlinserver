package com.example.kotlinserver.dao;

import com.example.kotlinserver.model.MessageInfo;

public interface MessageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}