package com.grinko.TravelBot.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class ConfigService {

    @Value("${bot.name}")
    public String BOT_NAME;
    @Value("${bot.token}")
    public String BOT_TOKEN;

    private static final Logger log = Logger.getLogger(ConfigService.class);

    public String getBotName() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }

//    static {
//
//        String configPath = "application.properties";
//
//        File configFile = new File(ConfigService.class.getClassLoader().getResource(configPath).getFile());
//        Properties properties = new Properties();
//
//        try {
//            properties.load(new FileReader(configFile));
//        } catch (IOException e) {
//            log.error("File: " + configPath + " is not exists.");
//        }
//        BOT_NAME = properties.getProperty("bot.name");
//        BOT_TOKEN = properties.getProperty("bot.token");
//    }
}
