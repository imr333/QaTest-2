package com.github.imr333.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactUsPage {

    SelenideElement nameField = $("input[name='first_name']");
    SelenideElement lastNameField = $("input[name='last_name']");
    SelenideElement emailAdressField = $("input[name='email']");
    SelenideElement commentField = $("textarea[placeholder='Comments']");

    private void inputName(String element) {
        nameField.setValue(element).shouldNotHave(text(element));
    }

    private void inputLastName(String element) {
        lastNameField.setValue(element).shouldNotHave(text(element));
    }

    private void inputEmailAdress(String element) {
        emailAdressField.setValue(element).shouldNotHave(text(element));
    }

    private void inputComment(String element) {
        commentField.setValue(element).shouldNotHave(text(element));
    }

    public ContactUsPage setValuesInFields() {
        inputName("Rory");
        inputLastName("McDonald");
        inputEmailAdress("keks@gmail.com");
        inputComment("go f*ck u self");
        return this;
    }

    public ContactUsPage resetForm() {
        $("[value='RESET']").click();
        nameField.shouldNotHave(text("Rory"));
        lastNameField.shouldNotHave(text("McDonald"));
        emailAdressField.shouldNotHave(text("keks@gmail.com"));
        commentField.shouldNotHave(text("go f*ck u self"));
        return this;
    }

    public ContactUsPage sumbitAndCheckForm() {
        $("input[value='SUBMIT']").click();
        $("#contact_reply > h1").shouldHave(text("Thank You for your Message!"));
        return this;
    }

    public ContactUsPage openPage() {
        open("/Contact-Us/contactus.html");
        $(".section_header").shouldBe(visible).shouldHave(text("CONTACT US"));
        return this;
    }
}
