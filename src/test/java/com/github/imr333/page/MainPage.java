package com.github.imr333.page;


import com.github.imr333.page.element.Navbar;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private Navbar navbar = new Navbar();

    public Navbar navbar() {
        return this.navbar;
    }

    public MainPage openPage() {
        open("/Page-Object-Model/index.html");
        return this;
    }

    public void checkPageIsOpen() {
        $("#nav-title").shouldHave(exactText("WebdriverUniversity.com (Page Object Model)"));
    }

}

//TODO: 1. сделать pageobject страницы "Our Products"
//TODO: 2. метод openOurProducts должен возвращать новую страницу +
//TODO: 3. в MainPageTest проверить открытие новой страницы, вызвав ее метод checkPageIsOpen
