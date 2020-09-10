package com.legenda.lee.studyurule.parse;

import com.bstek.urule.ClassUtils;
import com.legenda.lee.studyurule.controller.version1.DrugInfoOutput;

import java.io.File;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-15 11:13 上午
 * @description:
 */
public class ParseVariable {

    public static void main(String[] args) {
        File file=new File("/Users/legendalee/Desktop/DrugInfoOutput.xml");
        ClassUtils.classToXml(DrugInfoOutput.class, file);
    }
}
