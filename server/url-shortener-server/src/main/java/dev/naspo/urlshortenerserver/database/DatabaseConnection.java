package dev.naspo.urlshortenerserver.database;

// Handles database connection.
public class DatabaseConnection {
    String databaseHost = System.getenv("DATABASE_HOST");
    String databasePort = System.getenv("DATABASE_PORT");
    String databaseUser = System.getenv("DATABASE_USER");
    String databasePassword = System.getenv("DATABASE_PASSWORD");
    String databaseName = System.getenv("DATABASE_NAME");
}
