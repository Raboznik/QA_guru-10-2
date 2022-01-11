package ru.yandex.mkruchkov.pages;

import org.junit.jupiter.api.Test;


public class TestStudentRegistrationForm extends TestBase {

    TestData data = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageExam registrationPageExam = new RegistrationPageExam();

    @Test
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
                .uploadPicture("File")
                .selectState("Uttar")
                .selectCity("Agra")
                .submit();

        registrationPageExam
                .checkResultTable(data)
                .closeResultTable();

    }
}
