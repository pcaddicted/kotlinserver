package com.example.kotlinserver.service;


import com.example.kotlinserver.model.CartGoods;
import java.util.List;

public interface CartGoodsService {
    int addCartGoods(CartGoods paramCartGoods);

    List<CartGoods> getCartGoodsList(Integer paramInteger);

    void deleteCartGoods(List<Integer> paramList);
}
