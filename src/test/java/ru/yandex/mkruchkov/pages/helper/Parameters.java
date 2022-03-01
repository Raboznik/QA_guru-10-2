package ru.yandex.mkruchkov.pages.helper;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credential.properties")
public interface Parameters extends Config {
    @Key("credentials.properties.URL")
    String url();

    @Key("credentials.properties.login")
    String login();

    @Key("credentials.properties.password")
    String password();

}
