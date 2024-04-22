package dev.naspo.urlshortenerserver.database;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Handles database connection. Singleton class.
public class DatabaseConnection {
    private static DatabaseConnection instance;
    // Database connection information.
    private String databaseHost;
    private String databasePort;
    private String databaseUser;
    private String databasePassword;
    private String databaseName;
    // Built in constructor with database host, port, and name.
    // What we use to establish the connection.
    private String databaseUrl;

    private Connection conn; // Our database connection object.
    private DSLContext dslContext; // Data

    private DatabaseConnection() {
        // Instantiate database connection information.
        this.databaseHost = System.getenv("DATABASE_HOST");
        this.databasePort = System.getenv("DATABASE_PORT");
        this.databaseUser = System.getenv("DATABASE_USER");
        this.databasePassword = System.getenv("DATABASE_PASSWORD");
        this.databaseName = System.getenv("DATABASE_NAME");
        this.databaseUrl = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        // Establish the database connection and instantiate the cursor.
        try {
            conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
            dslContext = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Successfully connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public DSLContext getDslContext() {
        return dslContext;
    }

    public Connection getConnection() {
        return conn;
    }
}
