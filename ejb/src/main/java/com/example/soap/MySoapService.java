package com.example.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;

import org.apache.cxf.interceptor.InInterceptors;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService
@Stateless
//@EndpointConfig(configFile = "META-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@InInterceptors(interceptors = {
      "org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingPolicyInterceptor"}
)
public class MySoapService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
