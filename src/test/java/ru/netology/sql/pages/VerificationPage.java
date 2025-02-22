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

    public void verifyInvalid(String code) {
        codeInput.setValue(code);
        submitButton.click();
    }

    public void assertErrorMsg(String text) {
        $x("//*[@data-test-id='error-notification']//*[@class='notification__content']").
                shouldHave(Condition.text(text)).shouldBe(Condition.visible);
    }
}
