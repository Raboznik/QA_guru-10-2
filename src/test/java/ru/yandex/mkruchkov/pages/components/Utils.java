package ru.yandex.mkruchkov.pages.components;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Utils {

    @BeforeAll
    static void setBrowserSize() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void holdBrowser() {
        Configuration.holdBrowserOpen = false;
    }

    Faker faker = new Faker();

    private String name = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    private String address = faker.address().fullAddress();

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
