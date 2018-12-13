package com.example.kotlinserver.domain;

import java.util.List;

public class DeleteCartGoodsReq {
    private List<Integer> cartIdList;

    public List<Integer> getCartIdList() {
        return this.cartIdList;
    }

    public void setCartIdList(List<Integer> cartIdList) {
        this.cartIdList = cartIdList;
    }
}
