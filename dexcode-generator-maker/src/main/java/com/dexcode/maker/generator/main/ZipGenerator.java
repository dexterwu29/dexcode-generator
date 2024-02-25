package com.dexcode.maker.generator.main;

/**
 * 用于生成：代码生成器の压缩包
 */
public class ZipGenerator extends GenerateTemplate {

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        // 生成精简版程序
        String distPath = super.buildDist(outputPath, sourceCopyDestPath, jarPath, shellOutputFilePath);
        // 压缩包
        return super.buildZip(distPath);
    }
}
