package com.legenda.lee.studyurule.controller.actionlibrary;

import com.bstek.urule.action.ActionId;
import com.bstek.urule.model.ExposeAction;
import com.legenda.lee.studyurule.controller.Customer;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-19 10:47 上午
 * @description:
 */
@Service
public class MethodTest {

    @ActionId("Hello")
    public String hello() {
        return "hello";
    }


    @ExposeAction(value = "打印内容")
    public void printContent(String username, Date birthday) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (birthday != null) {
            System.out.println(username + "今年已经" + sd.format(birthday) + "岁了!");
        } else {
            System.out.println("Hello " + username + "");
        }
    }

    @ExposeAction(value = "打印Member")
    public void printUser(Customer m) {
        System.out.println("Hello " + m.getAge() + ", has house:" + m.getGender());
    }

}
