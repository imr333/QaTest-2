package com.github.imr333.tests;
import com.codeborne.selenide.Configuration;
import com.github.imr333.page.OurProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class OurProductsPageTest {

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
    public void checkCards() {
        new OurProductsPage()
                .openPage()
                .check();
    }

    @Test
    public void userCanOpenHomePage(){
        new OurProductsPage()
                .openPage()
                .navbar()
                .openMainPage();
    }

    @Test
    public void userCanOpenContactUsPage(){
        new OurProductsPage()
                .openPage()
                .navbar()
                .openContactUs();
    }
}
