package com.example.kotlinserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/shipAddress"})
public class ShipAddressController  extends BaseController {

}
