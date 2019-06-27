package com.example.webservice.client;

import com.example.springboot.webservice.server.service.AppService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class Test {
    /*
    <wsdl:definitions xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:tns="http://localhost:8087/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:ns2="http://schemas.xmlsoap.org/soap/http" xmlns:ns1="http://service.server.webservice.springboot.example.com/" name="AppServiceImplService" targetNamespace="http://localhost:8087/">
        <wsdl:import location="http://localhost:8087/services/user?wsdl=AppService.wsdl" namespace="http://service.server.webservice.springboot.example.com/"> </wsdl:import>
        <wsdl:binding name="AppServiceImplServiceSoapBinding" type="ns1:AppService">
        <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
        <wsdl:operation name="getUserName">
        <soap:operation soapAction="" style="document"/>
        <wsdl:input name="getUserName">
        <soap:body use="literal"/>
        </wsdl:input>
        <wsdl:output name="getUserNameResponse">
        <soap:body use="literal"/>
        </wsdl:output>
        </wsdl:operation>
        </wsdl:binding>
        <wsdl:service name="AppServiceImplService">
        <wsdl:port binding="tns:AppServiceImplServiceSoapBinding" name="testPort">
        <soap:address location="http://localhost:8087/services/user"/>
        </wsdl:port>
        </wsdl:service>
    </wsdl:definitions>
    */


    private static String serviceAddress = "http://localhost:8087/services/user?wsdl";
//    private static String serviceAddress = "http://localhost:8081/PatientService?wsdl";

    public static void main(String[] args){
        test1();
        test2();
    }

    /**
     * 使用代理类工厂模式获取，但是必须拿到对应的接口
     */
    private static void test1(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress(serviceAddress);
//        jaxWsProxyFactoryBean.getOutInterceptors().add()
        jaxWsProxyFactoryBean.setServiceClass(AppService.class);
        AppService service = (AppService) jaxWsProxyFactoryBean.create();
        String str = service.getUserName("1");
        System.out.println("WebService接口返回的数据[代理类工厂模式]：" + str);
    }

    /**
     * 动态调用方式
     */
    private static void test2(){
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient(serviceAddress);
//        client.getOutInterceptors().add(); // 添加拦截器
        try {
            Object[] result = client.invoke("getUserName", "1");
//            Object[] result = client.invoke("getPatient", "1");
            System.out.println("WebService接口返回的数据[动态调用方式]：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
