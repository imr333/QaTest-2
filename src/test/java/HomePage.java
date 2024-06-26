import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    SelenideElement visibleSlide1 = $("[src='../img/amp.svg']").shouldBe(visible);
    SelenideElement visibleSlide2 = $("[src='../img/boombox.svg']").shouldBe(visible);
    SelenideElement visibleSlide3 = $("[src='../img/nintendo.svg']").shouldBe(visible);
    SelenideElement rightCarouselControl = $(".right, carousel-control");
    SelenideElement leftCarouselControl = $(".left, carousel-control");

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://webdriveruniversity.com";
    }

    @AfterEach
    void afterEach() {
        sleep(1000);
        closeWebDriver();
    }

    /*сделал два метода с определением значений для навбаров на домашней странице*/
    public void topNavbar() {
        $(".navbar").shouldHave(text("WebdriverUniversity.com (Page Object Model)"));
    }

    public void middleNavbar() {
        $(".navbar-nav > .active").shouldHave(text("Home"));
    }

    /*метод проверки на соответствие выбранному слайду*/
    public void checkActualSlides() {
        /*сначала проверяем переключение слайдов по точкам*/
        $(".carousel-indicators > [data-slide-to='0']").click();
        visibleSlide1.shouldNotBe(visible);
        $(".carousel-indicators > [data-slide-to='1']").click();
        visibleSlide2.shouldBe(visible);
        $(".carousel-indicators > [data-slide-to='2']").click();
        visibleSlide3.shouldBe(visible);

        /*далее проверяем переключение слайда по стрелке вправо/влево*/
        sleep(1000);
        rightCarouselControl.click();
        visibleSlide1.shouldBe(visible);

        sleep(1000);
        rightCarouselControl.click();
        visibleSlide2.shouldBe(visible);

        sleep(1000);
        rightCarouselControl.click();
        visibleSlide3.shouldBe(visible);

        sleep(1000);
        leftCarouselControl.click();
        visibleSlide2.shouldBe(visible);

        sleep(1000);
        leftCarouselControl.click();
        visibleSlide1.shouldBe(visible);

        sleep(1000);
        leftCarouselControl.click();
        visibleSlide3.shouldBe(visible);
    }

    @Test
    void test() {
        open("/Page-Object-Model/index.html");

        topNavbar();
        middleNavbar();
        checkActualSlides();
    }
}
