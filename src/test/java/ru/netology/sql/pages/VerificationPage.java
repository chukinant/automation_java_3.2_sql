package ru.netology.sql.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.data.DbDataHelper;

import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private final SelenideElement codeInput = $x("//*[@data-test-id='code']//input");
    private final SelenideElement submitButton = $x("//button[@data-test-id='action-verify']");

    public VerificationPage() {
        codeInput.shouldBe(Condition.visible);
    }

    public LkPage verify(String code) {
        codeInput.setValue(code);
        submitButton.click();
        return new LkPage();
    }
}
