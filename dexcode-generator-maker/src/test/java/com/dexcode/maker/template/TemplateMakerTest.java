package com.dexcode.maker.template;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;
import com.dexcode.maker.meta.Meta;
import com.dexcode.maker.template.model.TemplateMakerConfig;
import com.dexcode.maker.template.model.TemplateMakerFileConfig;
import com.dexcode.maker.template.model.TemplateMakerModelConfig;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class TemplateMakerTest {

    /**
     * 测试 Bug 修复1：同配置多次生成，强制变为静态生成
     */
    @Test
    public void testMakeTemplateBug1() {
        Meta meta = new Meta();
        meta.setName("spring-boot-init-generator");
        meta.setDescription("Spring Boot 初始化模板生成器");

        String projectPath = System.getProperty("user.dir");
        String originProjectPath = new File(projectPath).getParent() + File.separator + "dexcode-generator-demo-projects/springboot-init";

        // 文件参数配置
        String inputFilePath1 = "src/main/resources/application.yml";
        TemplateMakerFileConfig templateMakerFileConfig = new TemplateMakerFileConfig();
        TemplateMakerFileConfig.FileInfoConfig fileInfoConfig1 = new TemplateMakerFileConfig.FileInfoConfig();
        fileInfoConfig1.setPath(inputFilePath1);
        templateMakerFileConfig.setFiles(Arrays.asList(fileInfoConfig1));

        // 模型参数配置
        TemplateMakerModelConfig templateMakerModelConfig = new TemplateMakerModelConfig();
        TemplateMakerModelConfig.ModelInfoConfig modelInfoConfig1 = new TemplateMakerModelConfig.ModelInfoConfig();
        modelInfoConfig1.setFieldName("url");
        modelInfoConfig1.setType("String");
        modelInfoConfig1.setDefaultValue("jdbc:mysql://localhost:3306/my_db");
        modelInfoConfig1.setReplaceText("jdbc:mysql://localhost:3306/my_db");
        templateMakerModelConfig.setModels(Arrays.asList(modelInfoConfig1));

        long id = TemplateMaker.makeTemplate(meta, 1744705904383320064L, originProjectPath, templateMakerFileConfig, templateMakerModelConfig, null);
        System.out.println(id);
    }

    /**
     * 测试 Bug 修复2：同目录多次生成时，会扫描新的 .ftl 文件
     */
    @Test
    public void testMakeTemplateBug2() {
        Meta meta = new Meta();
        meta.setName("spring-boot-init-generator");
        meta.setDescription("Spring Boot 初始化模板生成器");

        String projectPath = System.getProperty("user.dir");
        String originProjectPath = new File(projectPath).getParent() + File.separator + "dexcode-generator-demo-projects/springboot-init";

        // 文件参数配置
        String inputFilePath1 = "src/main/java/com/yupi/springbootinit/common";
        TemplateMakerFileConfig templateMakerFileConfig = new TemplateMakerFileConfig();
        TemplateMakerFileConfig.FileInfoConfig fileInfoConfig1 = new TemplateMakerFileConfig.FileInfoConfig();
        fileInfoConfig1.setPath(inputFilePath1);
        templateMakerFileConfig.setFiles(Arrays.asList(fileInfoConfig1));

        // 模型参数配置
        TemplateMakerModelConfig templateMakerModelConfig = new TemplateMakerModelConfig();
        TemplateMakerModelConfig.ModelInfoConfig modelInfoConfig1 = new TemplateMakerModelConfig.ModelInfoConfig();
        modelInfoConfig1.setFieldName("className");
        modelInfoConfig1.setType("String");
        modelInfoConfig1.setReplaceText("BaseResponse");
        templateMakerModelConfig.setModels(Arrays.asList(modelInfoConfig1));

        long id = TemplateMaker.makeTemplate(meta, 1744712881222180864L, originProjectPath, templateMakerFileConfig, templateMakerModelConfig, null);
        System.out.println(id);
    }

    /**
     * 使用 JSON 制作模板
     */
    @Test
    public void testMakeTemplateWithJSON() {
        String configStr = ResourceUtil.readUtf8Str("templateMaker.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        long id = TemplateMaker.makeTemplate(templateMakerConfig);
        System.out.println(id);
    }

    /**
     * 制作 SpringBoot 模板
     */
    @Test
    public void makeSpringBootTemplate() {
        // 0.项目基本信息
        String rootPath = "examples/springboot-init";
        String configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        long id = TemplateMaker.makeTemplate(templateMakerConfig);

        // 1.替换生成的代码包名
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker1.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 2.是否生成帖子相关功能
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker2.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 3.控制是否需要开启跨域控制
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker3.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 4.自定义Knife4jConfig接口文档配置
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker4.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker4_1.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 5.自定义MySQL配置信息
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker5.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 6.控制是否开启Redis
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker6.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);

        // 7.控制是否开启Elasticsearch
        configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker7.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);
        System.out.println(id);
    }
}