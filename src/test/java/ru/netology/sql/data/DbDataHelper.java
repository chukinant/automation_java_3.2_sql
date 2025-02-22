package ru.netology.sql.data;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDataHelper {
    private static final QueryRunner queryRunner = new QueryRunner();

    private DbDataHelper() {
    }

    @Value
    public static class User {
        String username;
        String password;
    }

    public static User getValidUserInfo() {
        return new User("vasya", "qwerty123");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getFirstUsername() {
        var usersSQL = "SELECT login FROM users ORDER BY login DESC LIMIT 1";
        try (var conn = getConnection()) {
            return queryRunner.query(conn, usersSQL, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";
        try (var conn = getConnection()) {
            return queryRunner.query(conn, codeSQL, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static void cleanVerificationCode() {
        try (var conn = getConnection()) {
            queryRunner.execute(conn, "DELETE FROM auth_codes");
        }
    }

    @SneakyThrows
    public static void cleanDB() {
        try (var conn = getConnection()) {
            queryRunner.execute(conn, "DELETE FROM card_transactions");
            queryRunner.execute(conn, "DELETE FROM cards");
            queryRunner.execute(conn, "DELETE FROM auth_codes");
            queryRunner.execute(conn, "DELETE FROM users");
        }
    }
}

