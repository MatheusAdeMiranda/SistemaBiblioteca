package com.cruzeiro.livro.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {

    private static final String URL = "jdbc:h2:file:/data/demo1";
    private static final String USER = "user";
    private static final String PASSWORD = "pass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() {
        try(Connection conn = DBConfig.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE LIVRO " +
                    "(id INT AUTO_INCREMENT not NULL, " +
                    " titulo VARCHAR(255), " +
                    " autor VARCHAR(255), " +
                    " numeroPaginas INT, " +
                    " ISBN VARCHAR(255), " +
                    " PRIMARY KEY ( id ));";

            stmt.executeUpdate("drop table if exists LIVRO");
            System.out.println(stmt.executeUpdate(sql));
            System.out.println("Criando tabela no banco de dados");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}