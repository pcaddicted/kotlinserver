package com.example.kotlinserver.service.impl;

import com.example.kotlinserver.dao.GoodsInfoMapper;
import com.example.kotlinserver.model.GoodsInfo;
import com.example.kotlinserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;
    @Override
    public List<GoodsInfo> selectAllGoodsList(Integer paramInteger) {
        return goodsInfoMapper.selectAllGoodsList(paramInteger);
    }

}
