package com.zzz.support;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.zzz.config.AppModule;
import com.zzz.config.model.ServerProperties;
import com.zzz.utils.CommandLineUtils;
import io.undertow.Undertow;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * @author 胡胜钧
 * @date 1/13 0013.
 */
@Slf4j
public class RestServer {

    private static final Integer PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String HOST = "localhost";

    private Injector injector = Guice.createInjector(new AppModule());

    @Inject
    private ServerProperties serverProperties;

    private void setServerProperties(String[] args) {
        serverProperties = injector.getInstance(ServerProperties.class);
        if (serverProperties == null) {
            serverProperties = new ServerProperties();
        }

        Integer port = CommandLineUtils.processCliArgsForPort(args);
        if (port != null) {
            log.info("use command line input port ({}) !", port);
            serverProperties.setPort(port);
        }
        if (serverProperties.getPort() == null) {
            log.info("use default port ({}) !", PORT);
            serverProperties.setPort(PORT);
        }
        if (serverProperties.getContextPath() == null) {
            log.info("use default context path ({})", CONTEXT_PATH);
            serverProperties.setContextPath(CONTEXT_PATH);
        }
        if (serverProperties.getHost() == null) {
            log.info("use default host ({}) !", HOST);
            serverProperties.setHost(HOST);
        }
    }

    public void startUp(String[] args) {
        this.setServerProperties(args);

        Undertow.Builder serverBuilder = Undertow.builder()
                .addHttpListener(serverProperties.getPort(), serverProperties.getHost());
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.start(serverBuilder);

        log.info("undertow start up on port ({})", serverProperties.getPort());

        ResteasyDeployment resteasyDeployment = new ResteasyDeployment();
        resteasyDeployment.setApplication(new MyApplication());
        resteasyDeployment.setProviders(Lists.newArrayList(new MyExceptionMapper()));
        server.deploy(resteasyDeployment, serverProperties.getContextPath());
    }

}
