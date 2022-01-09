package ru.yandex.mkruchkov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPageExam extends RegistrationPage {

    private SelenideElement
            close = $("#closeLargeModal");

    public RegistrationPageExam checkResultTable(String... exactTexts) {
        $$(".table td:last-child").shouldHave(exactTexts(exactTexts));
        return this;
    }

    public void closeResultTable() {
        close.click();
    }
}
