package com.dexcode.generator;

import com.dexcode.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 第二期の核心生成器
 */
public class MainGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("dexter");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("最终の求和结果：");
        doGenerate(mainTemplateConfig);
    }

    /**
     * 生成静态文件和动态文件
     *
     * @param model
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws IOException, TemplateException {
        // 当前idea打开的窗口
        String projectPath = System.getProperty("user.dir");
        // 找整个项目的根路径 dexcode-generator
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径 ACM的示例模板 在 dexcode-generator-demo-projects 目录下
        String inputPath = new File(parentFile + File.separator + "dexcode-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        // 生成动态文件，会覆盖部分已生成的静态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
