package ru.yandex.mkruchkov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.mkruchkov.pages.components.CalendarComponent;
import ru.yandex.mkruchkov.pages.components.Utils;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends Utils {


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

    public RegistrationPage setFirstName() {
        firstNameInput.setValue(getName());
        return this;
    }

    public RegistrationPage setLastName() {
        lastNameInput.setValue(getLastName());
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText(String.valueOf(hobbies))).click();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setEmail() {
        emailInput.setValue(getEmail());
        return this;
    }

    public RegistrationPage setNumber() {
        numberInput.setValue(getPhoneNumber());
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setCurrentAddress() {
        currentAddress.setValue(getAddress());
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

    public RegistrationPage submit() {
        submit.scrollIntoView(true).click();
        return new RegistrationPageExam();
    }
}
