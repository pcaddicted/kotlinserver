package com.example.kotlinserver.service;

import com.example.kotlinserver.model.GoodsInfo;
import com.example.kotlinserver.model.GoodsSku;

import java.util.List;

public interface GoodsService {

    int addGoods(GoodsInfo paramGoodsInfo);

    List<GoodsInfo> getGoodsList(Integer paramInteger1, Integer paramInteger2);

    List<GoodsInfo> getAllGoodsList(Integer paramInteger);

    GoodsInfo getGoodsDetail(Integer paramInteger);

    int addGoodsSku(GoodsSku paramGoodsSku);

    List<GoodsSku> getGoodsSkuList(Integer paramInteger);

    void modifyGoodsInfo(GoodsInfo paramGoodsInfo);

    List<GoodsInfo> getGoodsListByKeyword(String paramString);

}
