package com.zzz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zzz.config.module.AppModule;
import com.zzz.service.ZzzService;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());

        ZzzService zzzService = injector.getInstance(ZzzService.class);
        zzzService.save();
        zzzService.update();
        zzzService.delete();
    }

}
