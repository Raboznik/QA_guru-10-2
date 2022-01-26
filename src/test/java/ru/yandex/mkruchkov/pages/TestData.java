package ru.yandex.mkruchkov.pages;

import com.github.javafaker.Faker;

public class TestData  extends TestBase{

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
