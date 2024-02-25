package com.dexcode.maker;

import com.dexcode.maker.generator.main.GenerateTemplate;
import com.dexcode.maker.generator.main.MainGenerator;
import com.dexcode.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * 全局调用入口
 */
public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        GenerateTemplate generateTemplate= new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}