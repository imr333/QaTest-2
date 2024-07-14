package com.github.imr333.tests;

import com.codeborne.selenide.Configuration;
import com.github.imr333.page.ContactUsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class ContactUsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://webdriveruniversity.com";
    }

    @AfterEach
    void afterEach() {
        sleep(3000);
        closeWebDriver();
    }

    @Test
    public void resetAndSubmitForm(){
        new ContactUsPage()
                .openPage()
                .setValuesInForm()
                .resetForm()
                .checkResetForm()
                .setValuesInForm()
                .submitAndCheckForm();
    }
}
