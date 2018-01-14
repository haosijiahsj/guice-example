package com.zzz.support;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.config.model.ServerProperties;
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

    @Inject
    private ServerProperties serverProperties;

    public void startUp() {
        Undertow.Builder serverBuilder = Undertow.builder()
                .addHttpListener(serverProperties.getPort(), serverProperties.getHost());
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.start(serverBuilder);

        log.info("undertow start up on port ({})", serverProperties.getPort());

        DeploymentInfo deploymentInfo = server.undertowDeployment(MyApplication.class)
                .setClassLoader(RestServer.class.getClassLoader())
                .setContextPath(serverProperties.getServletPath())
                .setDeploymentName(serverProperties.getDeploymentName());

        server.deploy(deploymentInfo);
    }

}
