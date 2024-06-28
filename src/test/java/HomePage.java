import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

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
    public void checkTopNavbar() {
        $(".navbar").shouldHave(text("WebdriverUniversity.com (Page Object Model)"));
    }

    public void checkMiddleNavbar() {
        $(".navbar-nav > .active").shouldHave(text("Home"));
    }

    @Test
    @DisplayName("Проверка контента на соответствие странице")
    public void checkContentOnPage() {
        open("/Page-Object-Model/index.html");

        checkTopNavbar();
        checkMiddleNavbar();

        /*также решил проверить блоки на соответствие заголовка блока к его тексту
        норм ли создавать такие переменные как caption1 или это лютый колхоз?
        решил сделать так, поскольку все блоки вроде с одинаковыми атрибутами, и отличаются лишь по тексту.
        понимаю, что такие проверки большого смысла могут не нести, но интересно понять можно ли так делать?*/
        SelenideElement caption1 = $(".thumbnail").shouldHave(text("Who Are We?"));
        caption1.shouldHave(text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi elit sapien, tempus sit amet hendrerit volutpat, euismod vitae risus. Etiam consequat, sem et vulputate dapibus, diam enim tristique est, vitae porta eros mauris ut orci. Praesent sed velit odio. Ut massa arcu, suscipit viverra molestie at, aliquet a metus. Nullam sit amet tellus dui, ut tincidunt justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        /*не стал проверять все три кнопки по несколько раз открывая модалку*/
        $("#button-find-out-more").click();
        $(".modal-content").shouldNotBe(visible);
        $(".modal-footer > button[data-dismiss='modal']").shouldHave(text("Find Out More")).click();
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Our Products'")
    public void switchOnProductsPage() {
        open("/Page-Object-Model/index.html");

        $(byText("Our Products")).click();
        $("#nav-title").shouldHave(text("WebDriver (New Approach To Learning)"));

    }

    SelenideElement visibleSlide1 = $("[src='../img/amp.svg']");
    SelenideElement visibleSlide2 = $("[src='../img/boombox.svg']");
    SelenideElement visibleSlide3 = $("[src='../img/nintendo.svg']");
    SelenideElement rightCarouselControl = $(".right, carousel-control");
    SelenideElement leftCarouselControl = $(".left, carousel-control");

    public void checkActualSlides() {
        /*сначала проверяем переключение слайдов по точкам*/
        $(".carousel-indicators > [data-slide-to='0']").click();
        visibleSlide1.shouldBe(visible);
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

    /*метод проверки на соответствие выбранному слайду*/
    @Test
    @DisplayName("Проверка слайдов на соответствие")
    public void checkSlider() {
        open("/Page-Object-Model/index.html");

        checkActualSlides();
    }
}