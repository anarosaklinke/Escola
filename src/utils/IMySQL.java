package utils;

public interface IMySQL {

    final String USUARIO = "root";
    final String SENHA = "1234";
    final String URL = "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
    final String URL_SCHEMA = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
    final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
}
