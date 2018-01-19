package com.zzz.support;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.config.model.ServerProperties;
import com.zzz.utils.CommandLineUtils;
import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

/**
 * @author 胡胜钧
 * @date 1/13 0013.
 */
@Slf4j
@Singleton
public class RestServer {

    private static final Integer PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String HOST = "localhost";

    @Inject
    private ServerProperties serverProperties;

    private void setServerProperties(String[] args) {
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

        DeploymentInfo deploymentInfo = server.undertowDeployment(MyApplication.class)
                .setClassLoader(RestServer.class.getClassLoader())
                .setContextPath(serverProperties.getContextPath())
                .setDeploymentName(serverProperties.getDeploymentName());

        server.deploy(deploymentInfo);
    }

}
