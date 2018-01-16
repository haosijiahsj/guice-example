package com.zzz.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlUtils {

    public static <T> T getModelFromYaml(String path, String prefix, Class<T> clazz) {
        Yaml yaml = new Yaml();
        URL url = YamlUtils.class.getClassLoader().getResource(path);

        if (url == null) {
            throw new IllegalStateException("url为空！");
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
            throw new IllegalStateException(String.format("载入%s失败！", path), e);
        }
    }

}
