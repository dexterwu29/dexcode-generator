package com.dexcode.maker.template.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 模板制作文件配置
 */
@Data
public class TemplateMakerFileConfig {

    private List<FileInfoConfig> files;

    @NoArgsConstructor
    @Data
    public static class FileInfoConfig {

        /**
         * 文件（目录）路径
         */
        private String path;

        /**
         * 文件过滤配置
         */
        private List<FileFilterConfig> fileFilterConfigList;
    }
}
