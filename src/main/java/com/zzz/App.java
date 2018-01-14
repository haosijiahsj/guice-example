package com.zzz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zzz.config.AppModule;
import com.zzz.support.RestServer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        injector.getInstance(RestServer.class).startUp();
        log.info("guice-example服务启动成功！");
    }

}
