package com.legenda.lee.studyurule.controller.variablelibrary3;

import com.bstek.urule.model.Label;
import com.legenda.lee.studyurule.controller.variablelibrary.Desk;
import lombok.Data;

import java.util.List;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 6:03 下午
 * @description:
 */
@Data
public class DeskCheckXContext {

    @Label("桌子对象集合")
    private List<Desk> deskList;

    @Label("糟糕的高度对象集合")
    private List<Bad> badList;

    @Label("合格检验结果对象")
    private DeskXResult deskXResult;

}
