package com.example.kotlinserver.service.impl;

import com.example.kotlinserver.dao.GoodsInfoMapper;
import com.example.kotlinserver.model.GoodsInfo;
import com.example.kotlinserver.model.GoodsSku;
import com.example.kotlinserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @Override
    public int addGoods(GoodsInfo paramGoodsInfo) {
        return 0;
    }

    @Override
    public List<GoodsInfo> getGoodsList(Integer paramInteger1, Integer paramInteger2) {
        return null;
    }

    @Override
    public List<GoodsInfo> getAllGoodsList(Integer paramInteger) {
        return goodsInfoMapper.selectAllGoodsList(paramInteger);
    }

    @Override
    public GoodsInfo getGoodsDetail(Integer paramInteger) {
        return goodsInfoMapper.selectByPrimaryKey(paramInteger);
    }

    @Override
    public int addGoodsSku(GoodsSku paramGoodsSku) {
        return 0;
    }

    @Override
    public List<GoodsSku> getGoodsSkuList(Integer paramInteger) {
        return null;
    }

    @Override
    public void modifyGoodsInfo(GoodsInfo paramGoodsInfo) {

    }

    @Override
    public List<GoodsInfo> getGoodsListByKeyword(String paramString) {
        return goodsInfoMapper.selectGoodsListByKeyword(paramString);
    }

}
