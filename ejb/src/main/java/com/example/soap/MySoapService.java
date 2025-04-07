package com.example.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;

@WebService
@Stateless
public class MySoapService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
