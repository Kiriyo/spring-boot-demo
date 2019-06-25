package com.example.springboot.webservice.server.config;

import com.example.springboot.webservice.server.service.AppService;
import com.example.springboot.webservice.server.service.impl.AppServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    /**
     * 配置访问Service访问路径
     * spring boot2.0.6之后的版本与xcf集成，不需要定义如下方法：
     * 只需要配置csf.path=/services
     *
     * @return
     */
//    @Bean
//    public ServletRegistrationBean dispatcherServlet(){
//        return new ServletRegistrationBean(new CXFServlet(), "/services");
//    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus spingbus(){
        return new SpringBus();
    }

    @Bean
    public AppService appService(){
        return new AppServiceImpl();
    }


    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(spingbus(), appService());
//        添加认证
//        endpoint.getInInterceptors().add();
        endpoint.publish("/user");
        return endpoint;
    }


}
