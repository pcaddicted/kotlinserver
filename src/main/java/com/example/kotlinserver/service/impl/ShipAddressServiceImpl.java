package com.example.kotlinserver.service.impl;

import com.example.kotlinserver.dao.ShipAddressMapper;
import com.example.kotlinserver.model.ShipAddress;
import com.example.kotlinserver.service.ShipAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipAddressServiceImpl implements ShipAddressService {

    @Autowired
    ShipAddressMapper shipAddressMapper;

    @Override
    public int addShipAddress(ShipAddress paramShipAddress) {
        return 0;
    }

    @Override
    public List<ShipAddress> getShipAddress(Integer paramInteger) {
        return shipAddressMapper.getShipAddress(paramInteger);
    }

    @Override
    public int modifyShipAddress(ShipAddress paramShipAddress) {
        return 0;
    }

    @Override
    public int deleteShipAddress(Integer paramInteger) {
        return 0;
    }

    @Override
    public ShipAddress getShipAddressById(Integer paramInteger) {
        return null;
    }
}
