package ru.yandex.mkruchkov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPageExam extends TestData {


    private SelenideElement
            close = $("#closeLargeModal");

    public RegistrationPageExam checkResultTable(TestData data) {

        $$(".table td:last-child").shouldHave(exactTexts(
                data.getName() + " " + data.getLastName(),
                data.getEmail(),
                "Other",
                data.getPhoneNumber(),
                "27 October,1987",
                "English, Physics",
                "Reading, Music",
                "",
//                "File",
                data.getAddress(),
                "Haryana Panipat"));

        return this;
    }

    public void closeResultTable() {
        close.click();
    }
}
