package ru.yandex.mkruchkov;

import org.junit.jupiter.api.Test;
import ru.yandex.mkruchkov.pages.RegistrationPage;
import ru.yandex.mkruchkov.pages.RegistrationPageExam;
import ru.yandex.mkruchkov.pages.components.Utils;


public class TestStudentRegistrationForm extends Utils {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageExam registrationPageExam = new RegistrationPageExam();

    @Test
    void fillFormFieldsWithDsl() {
        registrationPage
                .openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender("Other")
                .setNumber()
                .setBirthDate("28", "October", "1987")
                .setSubjects("En").setSubjects("P")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setCurrentAddress()
                .uploadPicture("File")
                .selectState("Uttar")
                .selectCity("Agra")
                .submit();


        registrationPageExam.checkResultTable(registrationPage.getName() + " " +
                        registrationPage.getLastName(),
                registrationPage.getEmail(),
                "Other",
                registrationPage.getPhoneNumber(),
                "28 October,1987",
                "English, Physics",
                "Reading, Music",
                "File",
                registrationPage.getAddress(),
                "Uttar Pradesh Agra")
                .closeResultTable();
    }
}
