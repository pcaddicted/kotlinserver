package com.example.kotlinserver.domain;

public class DeleteShipAddressReq extends BaseReq {
    private Integer id;


    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}