package ru.yandex.mkruchkov.pages;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class TestStudentRegistrationForm extends TestBase {

    TestData data = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageExam registrationPageExam = new RegistrationPageExam();

    @DisplayName("Test with steps")
    @Tag("properties")
    @Test
    void studentsRegistrationFormTest() {

        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("type first name", () -> {
            registrationPage.typeFirstName(data.getName());
        });
        step("type last name", () -> {
            registrationPage.typeLastName(data.getLastName());
        });
        step("type email", () -> {
            registrationPage.typeEmail(data.getEmail());
        });
        step("select gender", () -> {
            registrationPage.typeGender("Other");
        });
        step("type phone number", () -> {
            registrationPage.typeNumber(data.getPhoneNumber());
        });
        step("select date birth", () -> {
            registrationPage.typeBirthDate("27", "October", "1987");
        });
        step("type subjects", () -> {
            registrationPage.typeSubjects("En").typeSubjects("P");
        });
        step("type hobbies", () -> {
            registrationPage.typeHobbies("Reading");
            registrationPage.typeHobbies("Music");
        });
        step("type current address", () -> {
            registrationPage.typeCurrentAddress(data.getAddress());
        });
        step("select state", () -> {
            registrationPage.selectState("Haryana");
        });
        step("select city", () -> {
            registrationPage.selectCity("Panipat");
        });
        step("submit form", () -> {
            registrationPage.submit();
        });

        step("checking filled form ", () -> {
            registrationPageExam.checkResultTable(data);
        });
        step("closing form", () -> {
            registrationPageExam.closeResultTable();
        });
    }

    @DisplayName("Test with dsl")
    @Test
    @Disabled
    void fillFormFieldsWithDsl() {

        registrationPage
                .openPage()
                .typeFirstName(data.getName())
                .typeLastName(data.getLastName())
                .typeEmail(data.getEmail())
                .typeGender("Other")
                .typeNumber(data.getPhoneNumber())
                .typeBirthDate("28", "October", "1987")
                .typeSubjects("En").typeSubjects("P")
                .typeHobbies("Reading")
                .typeHobbies("Music")
                .typeCurrentAddress(data.getAddress())
//                .uploadPicture("File")
                .selectState("Uttar")
                .selectCity("Agra")
                .submit();

        registrationPageExam
                .checkResultTable(data)
                .closeResultTable();

    }
}

