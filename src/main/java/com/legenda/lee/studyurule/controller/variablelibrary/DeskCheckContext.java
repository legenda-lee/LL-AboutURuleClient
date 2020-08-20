package com.legenda.lee.studyurule.controller.variablelibrary;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 6:03 下午
 * @description:
 */
@Data
public class DeskCheckContext {

    @Label("桌子对象")
    private Desk desk;

    @Label("合格检验结果对象")
    private DeskResult resultInfo;

}
