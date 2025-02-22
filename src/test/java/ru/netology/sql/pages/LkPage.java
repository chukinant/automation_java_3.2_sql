package ru.netology.sql.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LkPage {
    private final SelenideElement header = $x("//*[@data-test-id='dashboard']");

    public LkPage() {
        header.shouldBe(Condition.visible).shouldHave(Condition.text("Личный кабинет"));
    }
}
