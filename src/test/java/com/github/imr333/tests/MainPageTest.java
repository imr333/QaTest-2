package com.github.imr333.tests;

import com.codeborne.selenide.Configuration;
import com.github.imr333.page.ContactUsPage;
import com.github.imr333.page.MainPage;
import com.github.imr333.page.OurProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://webdriveruniversity.com";
    }

    @AfterEach
    void afterEach() {
        sleep(2000);
        closeWebDriver();
    }

    @Test
    public void checkUserCanOpenOurProductsPage() {
        new MainPage()
                .openPage()
                .navbar()
                .openOurProducts();
        new OurProductsPage()
                .checkPageIsOpen();
    }

    @Test
    public void checkUserCanOpenContactUs() {
        new MainPage()
                .openPage()
                .navbar()
                .openContactUs();
        new ContactUsPage()
                .checkPageIsOpen();

    }

    @Test
    public void checkUserCanOpenHome() {
        new MainPage()
                .openPage()
                .navbar()
                .openMainPage();
        new MainPage()
                .checkPageIsOpen();
    }
}
