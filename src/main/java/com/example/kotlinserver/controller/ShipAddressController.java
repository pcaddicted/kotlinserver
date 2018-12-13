package com.example.kotlinserver.controller;

import com.example.kotlinserver.domain.AddShipAddressReq;
import com.example.kotlinserver.domain.BaseResp;
import com.example.kotlinserver.domain.DeleteShipAddressReq;
import com.example.kotlinserver.domain.ModifyShipAddressReq;
import com.example.kotlinserver.model.ShipAddress;
import com.example.kotlinserver.service.ShipAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @RequestMapping(value = {"/getList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<ShipAddress>> getList(){
        BaseResp resp = new BaseResp();
        int id = Integer.valueOf(this.request.getHeader("token"));
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
        BaseResp resp = new BaseResp();
        int id = Integer.valueOf(this.request.getHeader("token"));
        if(StringUtils.isEmpty(req.getShipUserName())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人姓名不能为空");
            return resp;
        }
        if(StringUtils.isEmpty(req.getShipUserMobile())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人电话不能为空");
            return resp;
        }
        if(StringUtils.isEmpty(req.getShipAddress())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人地址不能为空");
            return resp;
        }
        ShipAddress shipAddress = new ShipAddress();
        shipAddress.setUserId(id);
        shipAddress.setShipAddress(req.getShipAddress());
        shipAddress.setShipUserMobile(req.getShipUserMobile());
        shipAddress.setShipUserName(req.getShipUserName());
        shipAddress.setShipIsDefault(req.getShipIsDefault());
        shipAddressService.addShipAddress(shipAddress);
        resp.setStatus(1);
        resp.setData(null);
        resp.setMessage("地址增加成功");
        return resp;
    }



    @RequestMapping(value = {"/modify"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp modify(@RequestBody ModifyShipAddressReq req){
        BaseResp resp = new BaseResp();
        if(StringUtils.isEmpty(req.getShipUserName())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人姓名不能为空");
            return resp;
        }
        if(StringUtils.isEmpty(req.getShipUserMobile())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人电话不能为空");
            return resp;
        }
        if(StringUtils.isEmpty(req.getShipAddress())){
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("收货人地址不能为空");
            return resp;
        }
        ShipAddress address = shipAddressService.getShipAddressById(req.getId());
        address.setUserId(req.getId());
        address.setShipAddress(req.getShipAddress());
        address.setShipUserMobile(req.getShipUserMobile());
        address.setShipUserName(req.getShipUserName());
        address.setShipIsDefault(req.getShipIsDefault());
        shipAddressService.modifyShipAddress(address);
        resp.setStatus(1);
        resp.setData(null);
        resp.setMessage("地址修改成功");
        return resp;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp delete(@RequestBody DeleteShipAddressReq req){
        BaseResp resp = new BaseResp();
        int addressId = req.getId();
        int state = shipAddressService.deleteShipAddress(addressId);
        if(state>0) {
            resp.setStatus(1);
            resp.setData(null);
            resp.setMessage("删除成功");
        }else{
            resp.setStatus(-1);
            resp.setData(null);
            resp.setMessage("删除失败");
        }
        return resp;
    }
}
