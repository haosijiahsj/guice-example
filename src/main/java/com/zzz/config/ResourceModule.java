package com.zzz.config;

import com.google.inject.AbstractModule;
import com.zzz.config.model.MybatisProperties;
import com.zzz.config.model.ServerProperties;
import com.zzz.utils.YamlUtils;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public class ResourceModule extends AbstractModule {

    private static final String CONFIG_PATH = "app.yml";
    private static final String SERVER_PREFIX = "server";

    @Override
    protected void configure() {
        this.bind(ServerProperties.class)
                .toInstance(YamlUtils.getModelFromYaml(CONFIG_PATH, SERVER_PREFIX, ServerProperties.class));
    }

}
