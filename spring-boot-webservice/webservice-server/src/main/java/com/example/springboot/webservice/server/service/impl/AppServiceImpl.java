package com.example.springboot.webservice.server.service.impl;

import com.example.springboot.webservice.server.service.AppService;

import javax.jws.WebService;

@WebService(name = "test", targetNamespace = "http://localhost:8087/", endpointInterface = "com.example.springboot.webservice.server.service.AppService")
public class AppServiceImpl implements AppService {
    @Override
    public String getUserName(String id) {
        return "zhangsan";
    }
}
