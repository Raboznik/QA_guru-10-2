package ru.yandex.mkruchkov.pages.helper;

import org.aeonbits.owner.Config;

public interface Parameters extends Config {
    @Key("URL")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();

}
