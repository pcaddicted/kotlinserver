package com.example.kotlinserver.model;

public class GoodsInfo {
    private Integer id;

    private Integer categoryId;

    private String goodsDesc;

    private String goodsDefaultIcon;

    private String goodsDefaultPrice;

    private String goodsDetailOne;

    private String goodsDetailTwo;

    private Integer goodsSalesCount;

    private Integer goodsStockCount;

    private String goodsCode;

    private String goodsDefaultSku;

    private String goodsBanner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public String getGoodsDefaultIcon() {
        return goodsDefaultIcon;
    }

    public void setGoodsDefaultIcon(String goodsDefaultIcon) {
        this.goodsDefaultIcon = goodsDefaultIcon == null ? null : goodsDefaultIcon.trim();
    }

    public String getGoodsDefaultPrice() {
        return goodsDefaultPrice;
    }

    public void setGoodsDefaultPrice(String goodsDefaultPrice) {
        this.goodsDefaultPrice = goodsDefaultPrice == null ? null : goodsDefaultPrice.trim();
    }

    public String getGoodsDetailOne() {
        return goodsDetailOne;
    }

    public void setGoodsDetailOne(String goodsDetailOne) {
        this.goodsDetailOne = goodsDetailOne == null ? null : goodsDetailOne.trim();
    }

    public String getGoodsDetailTwo() {
        return goodsDetailTwo;
    }

    public void setGoodsDetailTwo(String goodsDetailTwo) {
        this.goodsDetailTwo = goodsDetailTwo == null ? null : goodsDetailTwo.trim();
    }

    public Integer getGoodsSalesCount() {
        return goodsSalesCount;
    }

    public void setGoodsSalesCount(Integer goodsSalesCount) {
        this.goodsSalesCount = goodsSalesCount;
    }

    public Integer getGoodsStockCount() {
        return goodsStockCount;
    }

    public void setGoodsStockCount(Integer goodsStockCount) {
        this.goodsStockCount = goodsStockCount;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsDefaultSku() {
        return goodsDefaultSku;
    }

    public void setGoodsDefaultSku(String goodsDefaultSku) {
        this.goodsDefaultSku = goodsDefaultSku == null ? null : goodsDefaultSku.trim();
    }

    public String getGoodsBanner() {
        return goodsBanner;
    }

    public void setGoodsBanner(String goodsBanner) {
        this.goodsBanner = goodsBanner == null ? null : goodsBanner.trim();
    }
}