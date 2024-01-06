package com.dexcode.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 动态文件生成
 */
public class DynamicFileGenerator {
    /**
     * @param inputPath  模板文件输入路径
     * @param outputPath 生成代码的输出路径
     * @param model      参数配置
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径，模板文件的父级目录
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        // Template template = configuration.getTemplate(templateName);

        // 创建数据模型，从Main方法传递过来⏬

        // 第四期：如果文件不存在则创建目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 生成
        // Writer out = new FileWriter(outputPath);

        // 第三期：解决中文乱码问题
        Template template = configuration.getTemplate(templateName, "utf-8");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(outputPath)), StandardCharsets.UTF_8));
        template.process(model, out);

        // 生成后关闭文件
        out.close();
    }
}
