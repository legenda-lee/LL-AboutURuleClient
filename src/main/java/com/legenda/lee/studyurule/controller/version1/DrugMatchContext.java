package com.legenda.lee.studyurule.controller.version1;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-09-07 5:10 下午
 * @description:
 */
@Data
public class DrugMatchContext {

    /**
     * 药品数据匹配事件的规则引擎执行输入部分
     */
    @Label("输入部分")
    private DrugMatchInput drugMatchInput;

    /**
     * 药品数据匹配事件的规则引擎执行输出部分
     */
    @Label("输出部分")
    private DrugMatchOutput drugMatchOutput;

}
