package com.legenda.lee.studyurule.controller;


import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author Legenda-Lee(lee.legenda@gmail.com)
 * @date 2020-08-14 16:47:03
 * @description
 */
@Data
public class Customer {

    @Label("年龄")
    private Integer age;

    @Label("性别")
    private Integer gender;

}
