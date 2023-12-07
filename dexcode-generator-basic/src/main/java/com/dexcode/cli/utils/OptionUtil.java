package com.dexcode.cli.utils;

import java.lang.reflect.Field;
import java.util.*;

import picocli.CommandLine.Option;

public class OptionUtil {

    public static String[] processInteractiveOptions(Class<?> clazz, String[] args) {
        // 将传递过来的数组转成集合，方便添加
        Set<String> argSet = new LinkedHashSet<>(Arrays.asList(args));

        // 获取字段的Option注解
        for (Field field : clazz.getDeclaredFields()) {
            // 如果注解存在且其interactive属性为true，则执行以下操作
            Option option = field.getAnnotation(Option.class);
            if (option != null && option.interactive()) {
                if (!argSet.contains(option.names()[0])) {
                    argSet.add(option.names()[0]);
                }
            }
        }
        args = argSet.toArray(new String[0]);
        return args;
    }
}