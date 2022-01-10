package ru.yandex.mkruchkov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPageExam extends TestData {

    private SelenideElement
            close = $("#closeLargeModal"),
            resultTable = $(".table-responsive");

    public RegistrationPageExam checkResultTable() {
        $$(".table td:last-child").shouldHave(exactTexts(
                TestStudentRegistrationForm.data.getName() + " " + TestStudentRegistrationForm.data.getLastName(),
                TestStudentRegistrationForm.data.getEmail(),
                "Other",
                TestStudentRegistrationForm.data.getPhoneNumber(),
                "28 October,1987",
                "English, Physics",
                "Reading, Music",
                "File",
                TestStudentRegistrationForm.data.getAddress(),
                "Uttar Pradesh Agra"));

        return this;
    }

    public void closeResultTable() {
        close.click();
    }
}
