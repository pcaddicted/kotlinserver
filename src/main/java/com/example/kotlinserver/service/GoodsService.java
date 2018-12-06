package com.example.kotlinserver.service;

import com.example.kotlinserver.model.GoodsInfo;

import java.util.List;

public interface GoodsService {
    List<GoodsInfo> selectAllGoodsList(Integer paramInteger);
}
