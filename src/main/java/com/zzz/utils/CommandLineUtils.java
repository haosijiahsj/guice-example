package com.zzz.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

/**
 * 命令行工具类，使用commons-cli工具解析控制台参数，可以在启动时指定端口号
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandLineUtils {

    /**
     * 解析控制台输入的端口号
     * @param args
     * @return
     */
    public static Integer processCliArgsForPort(String[] args) {
        Options options = new Options();
        Option helpOption = Option.builder("h").longOpt("help").hasArg(false).desc("显示本帮助").build();
        Option portOption = Option.builder("p").longOpt("port").required(false).hasArg(true).desc("端口号").build();

        options.addOption(helpOption).addOption(portOption);

        CommandLineParser commandLineParser = new DefaultParser();
        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            if (commandLine.hasOption(helpOption.getOpt())) {
                new HelpFormatter().printHelp("java -jar app.jar", options);
                System.exit(0);
            }
            if (!commandLine.hasOption(portOption.getOpt())) {
                log.info("no command -p or --port input !");
                return null;
            }

            String portStr = commandLine.getOptionValue(portOption.getOpt());
            return Integer.parseInt(portStr);
        } catch (ParseException | NumberFormatException e) {
            log.info("parse -p args error ! cause: {}", e.getMessage());
            return null;
        }
    }

}
