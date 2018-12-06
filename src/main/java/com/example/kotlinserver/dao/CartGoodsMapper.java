package com.example.kotlinserver.dao;

import com.example.kotlinserver.model.CartGoods;

public interface CartGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartGoods record);

    int insertSelective(CartGoods record);

    CartGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartGoods record);

    int updateByPrimaryKey(CartGoods record);
}