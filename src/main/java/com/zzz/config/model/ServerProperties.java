package com.zzz.config.model;

import com.google.inject.Singleton;
import lombok.Data;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Singleton
@Data
public class ServerProperties {

    private Integer port;
    private String host;
    private String contextPath;
    private String deploymentName;

}
