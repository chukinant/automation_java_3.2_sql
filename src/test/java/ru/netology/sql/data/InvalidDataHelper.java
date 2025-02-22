package ru.netology.sql.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class InvalidDataHelper {
    private static final Faker faker = new Faker(new Locale("en"));

    private InvalidDataHelper() {
    }

    private static String genRandomUsername() {
        return faker.name().username();
    }

    private static String genRandomPassword() {
        return faker.internet().password();
    }

    private static String genRandomVerificationCode() {
        return faker.numerify("######");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo(genRandomUsername(), genRandomPassword());
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode(genRandomVerificationCode());
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
}
