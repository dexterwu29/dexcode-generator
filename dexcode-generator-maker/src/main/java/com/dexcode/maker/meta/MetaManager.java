package com.dexcode.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    // volatile，并发编程中常用的关键字，确保多线程环境下的内存可见性，这样meta一旦被修改，所有内存都能看见
    private static volatile Meta meta;

    public static Meta getMetaObject() {
        if (meta == null) {
            // 加锁
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 校验配置文件，处理默认值
        return newMeta;
    }
}
