package com.example.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.annotations.Policy;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService
// So this changes the namespace of the method from the reverse of our java package (e.g. soap.example.com)
// to whatever is nominated here
//( targetNamespace = "http://www.jboss.org/jbossws/ws-extensions/wssecuritypolicy" )
@Stateless
@EndpointConfig(configFile = "META-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@Policy(placement = Policy.Placement.BINDING, uri = "META-INF/JavaFirstPolicy.xml")
@InInterceptors(interceptors = {
      "org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingPolicyInterceptor"
//      "org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingInterceptor"
}
)
public class MySoapService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
