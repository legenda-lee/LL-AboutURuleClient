package com.legenda.lee.studyurule.controller;

import com.bstek.urule.KnowledgePackageReceiverServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-14 6:29 下午
 * @description:
 */
@Component
public class URuleServletRegistration {
    //此Servlet用于接收Urule服务端发布的知识包，使用开源版本时删除或者注释这个bean
    @Bean
    public ServletRegistrationBean registerURuleServlet(){
        return new ServletRegistrationBean(new KnowledgePackageReceiverServlet(),"/knowledgepackagereceiver");
    }
}
