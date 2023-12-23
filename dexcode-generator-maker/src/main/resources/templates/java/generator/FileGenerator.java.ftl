package ${basePackage}.generator;

import ${basePackage}.generator.StaticFileGenerator;
import ${basePackage}.generator.DynamicFileGenerator;
import ${basePackage}.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(DataModel model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

    <#list modelConfig.models as modelInfo>
        ${modelInfo.type} ${modelInfo.fieldName} = model.${modelInfo.fieldName};
    </#list>
    <#list fileConfig.files as fileInfo>

        <#if fileInfo.condition??>
        if (${fileInfo.condition}) {
            inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
            outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
            <#if fileInfo.generateType == "static">
            StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
            <#else >
            DynamicFileGenerator.doGenerate(inputPath, outputPath, model);
            </#if>
        }
        <#else>
        inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
        <#if fileInfo.generateType == "static">
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        <#else >
        DynamicFileGenerator.doGenerate(inputPath, outputPath, model);
        </#if>
        </#if>
    </#list>
    }
}