package ru.yandex.mkruchkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setBrowserSize() {
        Configuration.browserSize = "1920 x 1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Name");
        $("#userEmail").setValue("email");
        $("#currentAddress").setValue("Current Adress1");
        $("#permanentAddress").setValue("Permanent Address2");

        $("#submit").click();
    }
}
