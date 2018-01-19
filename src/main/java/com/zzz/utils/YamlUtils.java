package com.zzz.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlUtils {

    public static <T> T getModelFromYaml(String path, String prefix, Class<T> clazz) {
        Yaml yaml = new Yaml();
        URL url = YamlUtils.class.getClassLoader().getResource(path);

        if (url == null) {
            log.error("载入{}失败！", path);
            return null;
        }

        try (InputStream inputStream = url.openConnection().getInputStream()) {
            Map map = yaml.load(inputStream);
            Map valueMap = (Map) map.get(prefix);
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(t, valueMap.get(field.getName()));
            }
            return t;
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            log.error("解析{}到{}失败！", path, clazz.getName());
            return null;
        }
    }

}
