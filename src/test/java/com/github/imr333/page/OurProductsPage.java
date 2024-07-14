package com.github.imr333.page;

import com.github.imr333.page.element.CardProducts;
import com.github.imr333.page.element.Navbar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class OurProductsPage {

    private Navbar navbar = new Navbar();

    public Navbar navbar() {
        return this.navbar;
    }

    private CardProducts cardProducts = new CardProducts();

    public CardProducts check() {
        return cardProducts.checkCardProduct();
    }

    public OurProductsPage openPage() {
        open("/Page-Object-Model/products.html");
        return this;
    }

    public void checkPageIsOpen() {
        $x("//p[text()='Audio']").shouldBe(visible, ofSeconds(15)); //проверка того, что открыта страница "PRODUCTS"
    }
}
