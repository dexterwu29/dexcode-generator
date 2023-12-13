package com.dexcode.maker.generator.main;

/**
 * 用于生成：代码生成器
 */
public class MainGenerator extends GenerateTemplate {

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("-- 不要生成精简版程序包啦！~~>_<~~");
    }
}
