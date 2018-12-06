package com.example.kotlinserver.model;

public class GoodsSku {
    private Integer id;

    private Integer goodsId;

    private String goodsSkuTitle;

    private String goodsSkuContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSkuTitle() {
        return goodsSkuTitle;
    }

    public void setGoodsSkuTitle(String goodsSkuTitle) {
        this.goodsSkuTitle = goodsSkuTitle == null ? null : goodsSkuTitle.trim();
    }

    public String getGoodsSkuContent() {
        return goodsSkuContent;
    }

    public void setGoodsSkuContent(String goodsSkuContent) {
        this.goodsSkuContent = goodsSkuContent == null ? null : goodsSkuContent.trim();
    }
}