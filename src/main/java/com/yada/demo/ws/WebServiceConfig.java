package com.yada.demo.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public DefaultWsdl11Definition holiday() throws Exception {
        SimpleXsdSchema xsd = new SimpleXsdSchema(new ClassPathResource("hr.xsd"));
        xsd.afterPropertiesSet();

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("holiday");
        definition.setLocationUri("/services/holiday");
        definition.setSchema(xsd);

        return definition;
    }

}
