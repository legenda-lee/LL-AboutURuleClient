package com.legenda.lee.studyurule.controller;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 6:02 下午
 * @description:
 */
@Data
public class ResultInfo {

    @Label("核保结果")
    private String checkResult;

}
