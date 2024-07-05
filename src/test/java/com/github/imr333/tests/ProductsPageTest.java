package com.github.imr333.tests;
import com.codeborne.selenide.Configuration;
import com.github.imr333.page.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPageTest {

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
        new ProductsPage()
                .openPage()
                .check();
    }

    @Test
    public void userCanOpenHomePage(){
        new ProductsPage()
                .openPage()
                .navbar()
                .openHome();
    }

    @Test
    public void userCanOpenContactUsPage(){
        new ProductsPage()
                .openPage()
                .navbar()
                .openContactUs();
    }
}
