package com.zzz.support;


import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zzz.config.AppModule;
import com.zzz.controller.ZzzController;

import javax.ws.rs.core.Application;
import java.util.Set;

/**
 * @author 胡胜钧
 * @date 1/13 0013.
 */
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = Sets.newHashSet();
        Injector injector = Guice.createInjector(new AppModule());
        resources.add(injector.getInstance(ZzzController.class));
        return resources;
    }

}
