package com.github.imr333.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.imr333.page.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

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
        $x("//p[text()='Audio']").shouldBe(visible, ofSeconds(15)); //проверка того, что открыта страница "PRODUCTS"
    }

    @Test
    public void checkUserCanOpenContactUs() {
      new MainPage()
              .openPage()
              .navbar()
              .openContactUs();
      $("[name='contactme']").shouldBe(visible, ofSeconds(15));//проверка того, что открыта страница "CONTACT US"
    }
    @Test
    public void checkUserCanOpenHome(){
        new MainPage()
                .openPage()
                .navbar()
                .openHome();
        $("#nav-title").shouldHave(exactText("WebdriverUniversity.com (Page Object Model)"));
    }
}
