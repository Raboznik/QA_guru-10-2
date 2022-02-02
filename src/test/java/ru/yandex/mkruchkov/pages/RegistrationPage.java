package ru.yandex.mkruchkov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.mkruchkov.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends TestBase {


    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            currentAddress = $("#currentAddress"),
            picture = $("#uploadPicture"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");


    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String name) {
        firstNameInput.setValue(name);


        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeHobbies(String hobbies) {
        $(byText(String.valueOf(hobbies))).click();

        return this;
    }

    public RegistrationPage typeBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage typeNumber(String phoneNumber) {
        numberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage typeGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage typeSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage typeCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage uploadPicture(String file) {
        picture.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPageExam submit() {
        submit.scrollIntoView(true).click();
        return new RegistrationPageExam();
    }
}
