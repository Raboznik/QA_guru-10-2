package ru.yandex.mkruchkov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestStudentRegistrationForm {

    @BeforeAll
    static void setBrowserSize() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void holdBrowser() {
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillFormFields() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Maksim");
        $("#lastName").setValue("Kryuchkov");
        $("#userEmail").setValue("qwe@qwe.qw");
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#hobbiesWrapper").$(byText("Sports")).click();

        File file = new File("C:/java projects/QA_guru-10-2/src/test/resources/File");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Russia. Moscow. Kremlin-4-4");

        $("#react-select-3-input").setValue("Uttar").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();

        $("#submit").click();

        /*  $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
         $$(".react-datepicker__day--028")
         .filter(not(cssClass(".react-datepicker__day--outside-month")))
         .first().click();
         $("[aria-label$='October 28th, 1987']").click();
         $("#uploadPicture").uploadFromClasspath("C:/java projects/QA_guru-10-2/src/test/resources/File"); */

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Maksim"), text("Kryuchkov"), text("qwe@qwe.qw"),
                text("Male"), text("1234567891"), text("28 October,1987"), text("Economics, Physics"),
                text("Reading, Music, Sports"), text("File"), text("Russia. Moscow. Kremlin-4-4"),
                text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();
    }
}
