import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://webdriveruniversity.com";
    }

    @AfterEach
    void afterEach(){
        sleep(3000);
        closeWebDriver();
    }

    /*решил сделать два метода с определением значений для навбаров, на домашней странице*/
    public void topNavbar(){
        $(".navbar").shouldHave(text("WebdriverUniversity.com (Page Object Model)"));
    }
    public void middleNavbar(){
        $(".navbar-nav > .active").shouldHave(text("Home"));
    }

//    SelenideElement pointOfSlide1 = $(".carousel-indicators > [data-slide-to='0']");
//    SelenideElement pointOfSlide2 = $(".carousel-indicators > [data-slide-to='1']");
//    SelenideElement pointOfSlide3 = $(".carousel-indicators > [data-slide-to='2']");
//
//    SelenideElement slide1 = $("#slide-image-1");
//    SelenideElement slide2 = $("#slide-image-2");
//    SelenideElement slide3 = $("#slide-image-3");

    /*метод проверки на соответствие выбранному слайду, пока что не работает*/
    public void actualSlides(){
        $(".carousel-indicators > [data-slide-to='0']").click(ClickOptions.usingJavaScript());
        $("#slide-image-1").shouldNotBe(visible);

        $(".carousel-indicators > [data-slide-to='1']").click();
        $("#slide-image-2").shouldNotBe(visible);

        $(".carousel-indicators > [data-slide-to='2']").click();
        $("#slide-image-3").shouldNotBe(visible);
    }
    @Test
    void test(){
        open("/Page-Object-Model/index.html");

        /*проверка значений навбаров*/
        topNavbar();
        middleNavbar();
        actualSlides();


    }
}
