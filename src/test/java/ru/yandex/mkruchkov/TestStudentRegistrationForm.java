package ru.yandex.mkruchkov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestStudentRegistrationForm {

    @BeforeAll
    static void setBrowserSize() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void holdBrowser() {
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormFields() {


        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Maksim");
        $("#lastName").setValue("Kryuchkov");
        $("#userEmail").setValue("qwe@qwe.qw");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("October");

        $$(byText("28")).last().click();

        $("#subjectsInput").setValue("Ec").pressEnter();
        $("#subjectsInput").setValue("P").pressEnter();

        $(byText("Reading")).click();
        $(byText("Music")).click();


        File file = new File("C:/Users/hanty/IdeaProjects/QA_guru-10-2/src/test/java/ru/yandex/mkruchkov/File.txt");
        $("#uploadPicture").uploadFile(file);


        $("#currentAddress").setValue("Russia. Moscow. Kremlin-4-4");

        $("#react-select-3-input").setValue("Uttar").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();

        $("#submit").shouldBe(Condition.visible).click();


    }
}
