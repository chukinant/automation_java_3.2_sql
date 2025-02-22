package ru.netology.sql.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.data.DbDataHelper;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement usernameField = $x("//*[@data-test-id='login']//input");
    private final SelenideElement passwordField = $x("//*[@data-test-id='password']//input");
    private final SelenideElement submitButton = $x("//button[@data-test-id='action-login']");

    public VerificationPage validLogin(DbDataHelper.User info) {
        usernameField.setValue(info.getUsername());
        passwordField.setValue(info.getPassword());
        submitButton.click();
        return new VerificationPage();
    }
}
