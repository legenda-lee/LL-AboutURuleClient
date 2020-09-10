package com.legenda.lee.studyurule.controller.version1;

import com.bstek.urule.model.Label;
import lombok.Data;

import java.util.List;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-09-07 5:10 下午
 * @description:
 */
@Data
public class DrugMatchOutput {

    /**
     * 包含适用匹配规则的药品集合
     */
    @Label("包含适用匹配规则的药品集合")
    private List<DrugInfoOutput> drugInfoOutputList;

}
