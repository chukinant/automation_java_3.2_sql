package ru.netology.sql.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AccountPage {
    private final SelenideElement header = $x("//*[@data-test-id='dashboard']");

    public AccountPage() {
        header.shouldBe(Condition.visible).shouldHave(Condition.text("Личный кабинет"));
    }
}
