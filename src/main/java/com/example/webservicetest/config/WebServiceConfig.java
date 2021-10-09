package com.example.webservicetest.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: WebServiceConfig
 * @Author: hechengyao
 * @Description:
 * @Date: Created in 16:59 2021/7/14
 * @Modified By:
 */
@Data
@Configuration
public class WebServiceConfig {

    @Value("${mybdbs.ip}")
    String ip;

    @Value("${mybdbs.port}")
    String port;

    // @Autowired
    // private ServerServiceDemo serverServiceDemo;
    //
    // @Bean(name = Bus.DEFAULT_BUS_ID)
    // public SpringBus springBus() {
    //     return new SpringBus();
    // }
    //
    // @Bean
    // public Endpoint endpoint() {
    //     EndpointImpl endpoint = new EndpointImpl(springBus(), serverServiceDemo);
    //     endpoint.publish("/ws/api");
    //     return endpoint;
    // }

}





