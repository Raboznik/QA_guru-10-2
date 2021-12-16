package ru.yandex.mkruchkov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setBrowserSize() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Name");
        $("#userEmail").setValue("email@email.com");
        $("#currentAddress").setValue("zqwwqeaz");
        $("#permanentAddress").setValue("Permanent Address2");

        $("#submit").click();

        $("#output").shouldBe(Condition.visible);

        $("#output #name").shouldHave(text("Name"));
        $("#output #email").shouldHave(text("email@email.com"));
        $("#output #currentAddress").shouldHave(text("zqwwqeaz"));
        $("#output #permanentAddress").shouldHave(text("Permanent Address2"));

    }

}
