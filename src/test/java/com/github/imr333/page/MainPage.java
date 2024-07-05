package com.github.imr333.page;


import com.github.imr333.page.element.Navbar;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Navbar navbar = new Navbar();

    public Navbar navbar() {
        return this.navbar;
    }

    public MainPage openPage() {
        open("/Page-Object-Model/index.html");
        return this;
    }

}

//TODO: 1. сделать pageobject страницы "Our Products"
//TODO: 2. метод openOurProducts должен возвращать новую страницу +
//TODO: 3. в MainPageTest проверить открытие новой страницы, вызвав ее метод checkPageIsOpen
