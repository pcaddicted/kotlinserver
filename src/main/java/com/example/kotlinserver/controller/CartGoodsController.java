package com.example.kotlinserver.controller;
import com.example.kotlinserver.domain.AddCartGoodsReq;
import com.example.kotlinserver.domain.BaseResp;
import com.example.kotlinserver.domain.DeleteCartGoodsReq;
import com.example.kotlinserver.domain.SubmitCartReq;
import com.example.kotlinserver.model.CartGoods;
import com.example.kotlinserver.service.CartGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


public class CartGoodsController extends BaseController {
    @Autowired
    CartGoodsService cartGoodsService;

    @RequestMapping(value = {"/getList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<CartGoods>> getList(){
        BaseResp resp = new BaseResp();
        return resp;
    }

    @RequestMapping(value = {"/add"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> addCartGoods(@RequestBody AddCartGoodsReq req){
        BaseResp resp = new BaseResp();
        return resp;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp deleteCartGoods(@RequestBody DeleteCartGoodsReq req){
        BaseResp resp = new BaseResp();
        return resp;
    }

    @RequestMapping(value = {"/submit"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> submitCart(@RequestBody SubmitCartReq req){
        BaseResp resp = new BaseResp();
        return resp;
    }
}
