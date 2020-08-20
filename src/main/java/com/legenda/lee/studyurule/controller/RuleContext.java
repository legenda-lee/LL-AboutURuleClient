package com.legenda.lee.studyurule.controller;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 6:03 下午
 * @description:
 */
@Data
public class RuleContext {

    @Label("客户对象")
    private Customer customer;

    @Label("结果对象")
    private ResultInfo resultInfo;

}
