package ru.yandex.mkruchkov.pages.helper;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credential.properties")
public interface Parameters extends Config {
    @Key("URL")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();

}
