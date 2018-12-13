package com.example.kotlinserver.service.impl;

import com.example.kotlinserver.model.CartGoods;
import com.example.kotlinserver.service.CartGoodsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartGoodsServiceImpl implements CartGoodsService {

    @Override
    public int addCartGoods(CartGoods paramCartGoods) {

        return 0;
    }

    @Override
    public List<CartGoods> getCartGoodsList(Integer paramInteger) {
        return null;
    }

    @Override
    public void deleteCartGoods(List<Integer> paramList) {

    }
}
