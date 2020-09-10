package com.legenda.lee.studyurule.controller.version1;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-09-07 5:00 下午
 * @description:
 */
@Data
public class DrugInfoOutput {

    @Label("序号")
    private Long id;

    @Label("药品通用名")
    private String name;

    @Label("规格")
    private String spec;

    @Label("生产厂家")
    private String enterprise;

    @Label("国药准字")
    private String approvalNumber;

    @Label("条形码")
    private String barcode;

    @Label("适用匹配规则")
    private String suitableRule;

}
