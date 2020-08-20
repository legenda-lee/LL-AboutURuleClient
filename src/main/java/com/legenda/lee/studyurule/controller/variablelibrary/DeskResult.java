package com.legenda.lee.studyurule.controller.variablelibrary;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 6:02 下午
 * @description:
 */
@Data
public class DeskResult {

    @Label("合格品检查结果")
    private String checkResult;

}
