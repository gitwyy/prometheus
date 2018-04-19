package com.pay.aphrodite.core.config.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:RestTemplateConfig
 * @Author: yangyang.wang
 * @Date: 2018-04-19 19:44
 * @Version: 1.0
 * @Description: TODO
 **/
@Configuration
public class RestTemplateConfig {

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(@Qualifier("clientHttpRequestFactory") ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean(name = "clientHttpRequestFactory")
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }

}