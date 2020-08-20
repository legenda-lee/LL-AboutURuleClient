package com.legenda.lee.studyurule.controller;

import com.alibaba.fastjson.JSON;
import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.FlowExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.legenda.lee.studyurule.controller.variablelibrary.Desk;
import com.legenda.lee.studyurule.controller.variablelibrary.DeskCheckContext;
import com.legenda.lee.studyurule.controller.variablelibrary.DeskResult;
import com.legenda.lee.studyurule.controller.variablelibrary2.DeskCheckCountContext;
import com.legenda.lee.studyurule.controller.variablelibrary2.DeskCountResult;
import com.legenda.lee.studyurule.controller.variablelibrary3.Bad;
import com.legenda.lee.studyurule.controller.variablelibrary3.DeskCheckXContext;
import com.legenda.lee.studyurule.controller.variablelibrary3.DeskXResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Legenda-Lee(lee.legenda@gmail.com)
 * @date 2020-08-17 14:54:07
 * @description
 */
@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("/rule1")
    public Object rule1() throws IOException {
        //创建一个KnowledgeSession对象
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_1");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(24);
        customer.setGender(1);

        ResultInfo resultInfo = new ResultInfo();

        session.insert(customer);
        session.insert(resultInfo);

        session.fireRules();
        session.writeLogFile();


        System.out.println(customer + "-" + resultInfo);

        return customer + "-" + resultInfo;
    }

    @RequestMapping("/rule2")
    public Object rule2() throws IOException {
        //创建一个KnowledgeSession对象
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_2");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setGender(1);

        ResultInfo resultInfo = new ResultInfo();

        RuleContext ruleContext = new RuleContext();
        ruleContext.setCustomer(customer);
        ruleContext.setResultInfo(resultInfo);

        session.insert(ruleContext);

        session.fireRules();
        session.writeLogFile();

        System.out.println(ruleContext);

        return ruleContext;
    }

    @RequestMapping("/rule3")
    public String rule3() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_3");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);
        Map<String, Object> param = new HashMap();
        //参数，var，传入参数，和参数库中定义一致
        param.put("age", 12);
        param.put("gender", 1);
        session.fireRules(param);
        //result，返回参数，和参数库中定义一致
        String checkResult = (String) session.getParameter("checkResult");
        return checkResult;
    }

    @RequestMapping("/rule4")
    public RuleContext rule4() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_5");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(21);
        customer.setGender(1);

        ResultInfo resultInfo = new ResultInfo();

        RuleContext ruleContext = new RuleContext();
        ruleContext.setCustomer(customer);
        ruleContext.setResultInfo(resultInfo);

        session.insert(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        session.startProcess("decision_flow_1");
        session.writeLogFile();

        System.out.println(ruleContext);

        return ruleContext;
    }

    @RequestMapping("/rule5")
    public RuleContext rule5() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_5");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setGender(1);

        ResultInfo resultInfo = new ResultInfo();

        RuleContext ruleContext = new RuleContext();
        ruleContext.setCustomer(customer);
        ruleContext.setResultInfo(resultInfo);

        session.insert(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        FlowExecutionResponse flowExecutionResponse = session.startProcess("decision_flow_1");
        System.out.println(JSON.toJSONString(flowExecutionResponse));
        // flowExecutionResponse中没有东西返回

        List<KnowledgePackage> knowledgePackageList =  session.getKnowledgePackageList();
        System.out.println(JSON.toJSONString(knowledgePackageList));

        List<Object> facts = session.getFactList();
        // 空的
        // System.out.println((RuleContext)facts.get(0));


        session.writeLogFile();


        System.out.println(ruleContext);

        return ruleContext;
    }


    @RequestMapping("/rule6")
    public DeskCheckContext rule6() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_6");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Desk desk = new Desk();
        desk.setHeight(20);
        desk.setWeight(20);

        DeskResult resultInfo = new DeskResult();

        DeskCheckContext ruleContext = new DeskCheckContext();
        ruleContext.setDesk(desk);
        ruleContext.setResultInfo(resultInfo);

        session.insert(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        session.startProcess("decision_flow_2");
        session.writeLogFile();

        System.out.println(ruleContext);

        return ruleContext;
    }

    @RequestMapping("/rule7")
    public DeskCheckCountContext rule7() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_7");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Desk desk = new Desk();
        desk.setHeight(20);
        desk.setWeight(20);

        Desk desk1 = new Desk();
        desk1.setHeight(30);
        desk1.setWeight(20);

        Desk desk2 = new Desk();
        desk2.setHeight(20);
        desk2.setWeight(20);

        Desk desk3 = new Desk();
        desk3.setHeight(20);
        desk3.setWeight(20);

        DeskCountResult resultInfo = new DeskCountResult();

        DeskCheckCountContext ruleContext = new DeskCheckCountContext();
        List<Desk> desks = new ArrayList<>();
        desks.add(desk);
        desks.add(desk1);
        // desks.add(desk2);
        // desks.add(desk3);
        ruleContext.setDeskList(desks);
        ruleContext.setDeskCountResult(resultInfo);

        session.insert(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        session.startProcess("decision_flow_3");
        session.writeLogFile();

        System.out.println(ruleContext);

        return ruleContext;
    }

    @RequestMapping("/rule8")
    public DeskCheckXContext rule8() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_8");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Desk desk = new Desk();
        desk.setHeight(1);

        Desk desk1 = new Desk();
        desk1.setHeight(2);

        Desk desk2 = new Desk();
        desk2.setHeight(3);

        Desk desk3 = new Desk();
        desk3.setHeight(4);

        DeskXResult resultInfo = new DeskXResult();

        DeskCheckXContext ruleContext = new DeskCheckXContext();
        List<Desk> desks = new ArrayList<>();
        desks.add(desk);
        desks.add(desk1);
        desks.add(desk2);
        desks.add(desk3);


        Bad bad = new Bad();
        bad.setBadHeight(3);

        Bad bad1 = new Bad();
        bad1.setBadHeight(5);

        List<Bad> bads = new ArrayList<>();
        bads.add(bad);
        bads.add(bad1);
        ruleContext.setDeskList(desks);

        ruleContext.setBadList(bads);
        ruleContext.setDeskXResult(resultInfo);

        session.insert(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        session.startProcess("decision_flow_4");
        session.writeLogFile();

        System.out.println(ruleContext);

        return ruleContext;
    }


    @RequestMapping("/rule9")
    public DeskCheckContext rule9() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("product-1/knowledge_1");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);


        Customer customer = new Customer();
        customer.setAge(24);
        customer.setGender(1);

        ResultInfo resultInfo = new ResultInfo();

        session.insert(customer);
        session.insert(resultInfo);

        session.fireRules();
        session.writeLogFile();


        System.out.println(customer + "-" + resultInfo);


        KnowledgePackage knowledgePackage1 = knowledgeService.getKnowledge("product-1/knowledge_2");
        session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage1);

        Customer customer1 = new Customer();
        customer1.setAge(20);
        customer1.setGender(1);

        ResultInfo resultInfo1 = new ResultInfo();

        RuleContext ruleContext = new RuleContext();
        ruleContext.setCustomer(customer1);
        ruleContext.setResultInfo(resultInfo1);

        session.insert(ruleContext);

        session.fireRules();
        session.writeLogFile();

        System.out.println(ruleContext);

        // startProcess的参数ID并不是知识包ID，而是流程的ID，所以后面一定要注意。
        session.startProcess("decision_flow_2");
        session.writeLogFile();

        System.out.println(ruleContext);

        return null;
    }



}

