package ru.yandex.mkruchkov.pages.helper;

import org.aeonbits.owner.Config;

    @Config.Sources("classpath:config/ServerConfig.properties")
    public interface Credentials extends Config {
        @Key("https.server.host")
        String url();

        @Key("server.host.login")
        String login();

        @Key("server.host.password")
        String password();

    }

