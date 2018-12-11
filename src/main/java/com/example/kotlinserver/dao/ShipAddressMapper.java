package com.example.kotlinserver.dao;

import com.example.kotlinserver.model.ShipAddress;
import java.util.List;

public interface ShipAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipAddress record);

    int insertSelective(ShipAddress record);

    ShipAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipAddress record);

    int updateByPrimaryKey(ShipAddress record);

    List<ShipAddress> getShipAddress(Integer userid);
}