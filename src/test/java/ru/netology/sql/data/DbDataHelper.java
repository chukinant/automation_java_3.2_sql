package ru.netology.sql.data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DbDataHelper {

    private DbDataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    @Value
    public static class AuthInfo {
        String username;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static int generateAmount(int currentBalance) {
        Faker faker = new Faker();
        return faker.number().numberBetween(0, currentBalance);
    }

    @Value
    public static class CardInfo {
        String id;
        String number;
    }

    public static CardInfo getFistCardInfo() {
        return new CardInfo("92df3f1c-a033-48e6-8390-206f6b1f56c0", "5559 0000 0000 0001");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("0f3f5c2a-249e-4c3d-8287-09f7a039391d", "5559 0000 0000 0002");
    }
}

