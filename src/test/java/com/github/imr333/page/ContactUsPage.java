package com.github.imr333.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class ContactUsPage {

    private final SelenideElement nameField = $("input[name='first_name']");
    private final SelenideElement lastNameField = $("input[name='last_name']");
    private final SelenideElement emailAdressField = $("input[name='email']");
    private final SelenideElement commentField = $("textarea[placeholder='Comments']");

    public ContactUsPage inputName(String element) {
        nameField.setValue(element).shouldNotHave(text(element));
        return this;
    }

    public ContactUsPage inputLastName(String element) {
        lastNameField.setValue(element).shouldNotHave(text(element));
        return this;
    }

    public ContactUsPage inputEmailAdress(String element) {
        emailAdressField.setValue(element).shouldNotHave(text(element));
        return this;
    }

    public ContactUsPage inputComment(String element) {
        commentField.setValue(element).shouldNotHave(text(element));
        return this;
    }

    public ContactUsPage setValuesInForm() {
        inputName("Rory");
        inputLastName("McDonald");
        inputEmailAdress("keks@gmail.com");
        inputComment("go f*ck u self");
        return this;
    }

    public ContactUsPage resetForm() {
        $("[value='RESET']").click();
        return this;
    }

    public ContactUsPage checkResetForm() {
        nameField.shouldNotHave(text("Rory"));
        lastNameField.shouldNotHave(text("McDonald"));
        emailAdressField.shouldNotHave(text("keks@gmail.com"));
        commentField.shouldNotHave(text("go f*ck u self"));
        return this;
    }

    public ContactUsPage submitAndCheckForm() {
        $("input[value='SUBMIT']").click();
        $("#contact_reply > h1").shouldHave(text("Thank You for your Message!"));
        return this;
    }

    public ContactUsPage openPage() {
        open("/Contact-Us/contactus.html");
        $(".section_header").shouldHave(text("CONTACT US"));
        return this;
    }
    public void checkPageIsOpen(){
        $("[name='contactme']").shouldBe(visible, ofSeconds(15));//проверка того, что открыта страница "CONTACT US"
    }
}
