package ru.yandex.mkruchkov.pages.helper;

import org.aeonbits.owner.Config;

    @Config.Sources("classpath:config/credential.properties")
    public interface Credentials extends Config {
        @Key("credential.properties.url")
        String url();

        @Key("credential.properties.login")
        String login();

        @Key("credential.properties.password")
        String password();

    }

