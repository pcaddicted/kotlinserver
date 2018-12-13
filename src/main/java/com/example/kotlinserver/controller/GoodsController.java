package com.example.kotlinserver.controller;

import com.example.kotlinserver.domain.BaseResp;
import com.example.kotlinserver.domain.GetGoodsDetailReq;
import com.example.kotlinserver.domain.GetGoodsListByKeywordReq;
import com.example.kotlinserver.domain.GetGoodsListReq;
import com.example.kotlinserver.model.GoodsInfo;
import com.example.kotlinserver.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/goods"})
public class GoodsController extends BaseController{
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = {"/getGoodsList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsList(@RequestBody GetGoodsListReq req) {
        BaseResp resp = new BaseResp();
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<GoodsInfo> list = this.goodsService.getAllGoodsList(req.getCategoryId());
        if(list==null || list.size()==0){
            resp.setMessage("没有商品");
            resp.setStatus(-1);
            resp.setData(null);
        }
        resp.setMessage("获取成功");
        resp.setStatus(1);
        resp.setData(list);
        return resp;
    }

    @RequestMapping(value = {"/getGoodsDetail"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<GoodsInfo> getGoodsDetail(@RequestBody GetGoodsDetailReq req){
        return null;
    }

    @RequestMapping(value = {"/getGoodsListByKeyword"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsListByKeyword(@RequestBody GetGoodsListByKeywordReq req){
        return null;
    }
}
