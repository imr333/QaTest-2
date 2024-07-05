package com.github.imr333.page.element;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CardProducts {

    SelenideElement modal = $(".modal-content");
    SelenideElement modalHeader = $(".modal-header");

    private void openAndCloseSpecialOffers() {
        $("#container-special-offers").click();
        $(modal).shouldBe(visible);
        $(modalHeader).shouldHave(text("SPECIAL OFFER!"));
        $(byText("Close")).click(); //Закрыть с помощью кнопки "Close"
        $("#container-special-offers").click();
        $(byText("Proceed")).click(); //Закрыть с помощью кнопки "Proceed"
    }

    private void openAndCloseCamerasCard() {
        $("#container-product1").click();
        $(modal).shouldBe(visible);
        $(modalHeader).shouldHave(text("SPECIAL OFFER!"));
        $(byText("Close")).click(); //Закрыть с помощью кнопки "Close"
        $("#container-special-offers").click();
        $(byText("Proceed")).click(); //Закрыть с помощью кнопки "Proceed"
    }

    private void openAndCloseAudio() {
        $("#container-product7").click();
        $(modal).shouldBe(visible);
        $(modalHeader).shouldHave(text("SPECIAL OFFER!"));
        $(byText("Close")).click(); //Закрыть с помощью кнопки "Close"
        $("#container-special-offers").click();
        $(byText("Proceed")).click(); //Закрыть с помощью кнопки "Proceed"
    }

    public CardProducts checkCardProduct(){
        openAndCloseSpecialOffers();
        openAndCloseCamerasCard();
        openAndCloseAudio();
        return this;
    }
}
