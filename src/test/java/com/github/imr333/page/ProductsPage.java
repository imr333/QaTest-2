package com.github.imr333.page;
import com.github.imr333.page.element.CardProducts;
import com.github.imr333.page.element.Navbar;
import static com.codeborne.selenide.Selenide.open;

public class ProductsPage {

    Navbar navbar = new Navbar();

    public Navbar navbar() {
        return this.navbar;
    }

    CardProducts cardProducts = new CardProducts();

    public CardProducts check() {
        return cardProducts.checkCardProduct();
    }

    public ProductsPage openPage() {
        open("/Page-Object-Model/products.html");
        return this;
    }
}
