package com.example.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.annotation.security.PermitAll;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.annotations.Policy;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService
@Stateless
@EndpointConfig(configFile = "META-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@Policy(placement = Policy.Placement.BINDING, uri = "META-INF/JavaFirstPolicy.xml")
@InInterceptors(interceptors = { "org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingPolicyInterceptor" })
@PermitAll
public class MySoapService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
