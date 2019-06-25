package com.example.springboot.webservice.server.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AppService {

    @WebMethod(operationName = "getUserName")
    String getUserName(@WebParam(name = "id") String id);




}
