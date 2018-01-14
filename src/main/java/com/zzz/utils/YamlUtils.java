package com.zzz.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static <T> T getServerModelFromYaml(String path, Class<T> clazz) {
        Yaml yaml = new Yaml();
        URL url = YamlUtils.class.getClassLoader().getResource(path);

        if (url == null) {
            throw new IllegalStateException("url为空！");
        }

        try (FileInputStream fileInputStream = new FileInputStream(url.getFile())) {
            Map map = yaml.load(fileInputStream);
            Map valueMap = (Map) map.get("server");
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
