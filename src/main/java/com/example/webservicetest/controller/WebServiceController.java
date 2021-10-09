package com.example.webservicetest.controller;

import com.example.webservicetest.config.WebServiceConfig;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HeChengyao
 * @date: 2021/7/20 14:26
 */
@RestController
@RequestMapping("/asd")
public class WebServiceController {

    private static final Logger log = LoggerFactory.getLogger(WebServiceController.class);

    @Autowired
    private WebServiceConfig webServiceConfig;

    // @IgnoreBehToken
    @RequestMapping("/fgh")
    public void invokeService() {
        log.info("创建动态客户端");
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        String myIp = webServiceConfig.getIp();
        log.info("myIp= {}", myIp);
        String myPort = webServiceConfig.getPort();
        log.info("myPort= {}", myPort);
        String url = String.format("http://%s:%s/services/ws/api?wsdl", myIp, myPort);
        // String url = String.format("http://localhost:18290/services/ws/api?wsdl");
        log.info("url= {}", url);
        Client client = dcf.createClient(url);
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            //这里注意如果是复杂参数的话，要保证复杂参数可以序列化
            objects = client.invoke("hello", "hello world");
            log.info("返回数据: {}", objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/find")
    public String findDog() throws Exception {

        String findDog = "";
        findDog = "fbawnbaewkjfnck";
        System.out.println(">>>>> findDog = " + findDog);
        return findDog;
    }

}
