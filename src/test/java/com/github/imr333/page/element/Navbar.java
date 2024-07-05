package com.github.imr333.page.element;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Navbar {

    private final SelenideElement navbar = $("ul.navbar-nav");

    private void openBy(String locator) {
        navbar.shouldBe(visible).$(locator).click();
    }

    public void openOurProducts() {
        openBy("a[href='products.html']"); //переход на страницу "Products"
//
//        switchTo().newWindow(WindowType.TAB); //открыть страницу "Products" в новой вкладке
//        open("/Page-Object-Model/products.html"); //адрес новой вкладки
    }

    public void openContactUs() {
        openBy("a[href*='contactus.html']");

//        switchTo().newWindow(WindowType.TAB); //открыть страницу "Products" в новой вкладке
//        open("/Contact-Us/contactus.html"); //адрес новой вкладки
    }

    public void openHome(){
        openBy("a[href='index.html']");
    }

}