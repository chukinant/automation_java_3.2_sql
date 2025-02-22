package ru.netology.sql;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.netology.sql.data.DbDataHelper;
import ru.netology.sql.pages.LkPage;
import ru.netology.sql.pages.LoginPage;
import ru.netology.sql.pages.VerificationPage;

public class AuthenticationTest {
    LkPage lkPage;
    VerificationPage verificationPage;
    LoginPage loginPage;
    DbDataHelper.User validAuthInfo = DbDataHelper.getValidUserInfo();

    @BeforeEach
    void setUp() {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
    }

    @AfterEach
    void resetAuthCodesTable() {
        DbDataHelper.cleanVerificationCode();
    }

    @AfterAll
    static void resetDB() {
        DbDataHelper.cleanDB();
    }

    @Test
    @DisplayName("User should be logged in with valid credentials")
    void shouldLogin () {
        verificationPage = loginPage.validLogin(validAuthInfo);
        lkPage = verificationPage.verify(DbDataHelper.getVerificationCode());
    }

}
