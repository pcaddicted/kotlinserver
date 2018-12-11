package com.example.kotlinserver.controller;

import com.example.kotlinserver.domain.AddShipAddressReq;
import com.example.kotlinserver.domain.BaseResp;
import com.example.kotlinserver.domain.DeleteShipAddressReq;
import com.example.kotlinserver.domain.ModifyShipAddressReq;
import com.example.kotlinserver.model.ShipAddress;
import com.example.kotlinserver.model.UserInfo;
import com.example.kotlinserver.service.ShipAddressService;
import com.example.kotlinserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/shipAddress"})
public class ShipAddressController  extends BaseController {

    @Autowired
    private ShipAddressService shipAddressService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/getList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<ShipAddress>> getList(){
        BaseResp resp = new BaseResp();
        int id = Integer.valueOf(this.request.getHeader("token"));
        UserInfo user = userService.getUserById(id);
        if(user == null){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("当前用户不存在");
            return resp;
        }
        List list = shipAddressService.getShipAddress(id);
        if(list == null){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("地址列表为空");
            return resp;
        }else{
            resp.setStatus(-1);
            resp.setData(list);
            resp.setMessage("获取成功");
            return resp;
        }
    }

    @RequestMapping(value = {"/add"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp add(@RequestBody AddShipAddressReq req){
        return null;
    }

    @RequestMapping(value = {"/modify"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp modify(@RequestBody ModifyShipAddressReq req){
        return null;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp delete(@RequestBody DeleteShipAddressReq req){
        return null;
    }
}
