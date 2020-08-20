package com.legenda.lee.studyurule.controller.variablelibrary;


import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * @author Legenda-Lee(lee.legenda@gmail.com)
 * @date 2020-08-14 16:47:03
 * @description
 */
@Data
public class Desk {

    @Label("高度")
    private Integer height;

    @Label("宽度")
    private Integer weight;

}
