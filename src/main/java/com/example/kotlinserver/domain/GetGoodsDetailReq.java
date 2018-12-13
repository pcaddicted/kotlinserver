package com.example.kotlinserver.domain;

public class GetGoodsDetailReq extends BaseReq {
    private Integer goodsId;

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
