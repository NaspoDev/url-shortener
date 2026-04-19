package dev.naspo.urlshortenerserver.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

// Handles database connection.
@Service
public class DatabaseService {
    // Database connection information.
    private String databaseHost;
    private String databasePort;
    private String databaseUser;
    private String databasePassword;
    private String databaseName;
    // Built in constructor with database host, port, and name.
    // What we use to establish the connection.
    private String databaseUrl;

    private DSLContext dslContext; // JOOQ MySQL domain specific language. (Interacting with db)
    private HikariConfig hikariConfig; // Hikari db connection pool config.
    private HikariDataSource dataSource; // Hikari db connection pool itself. (Uses hikari config)

    public DatabaseService() {
        // Instantiate database connection information.
        this.databaseHost = System.getenv("DATABASE_HOST");
        this.databasePort = System.getenv("DATABASE_PORT");
        this.databaseUser = System.getenv("DATABASE_USER");
        this.databasePassword = System.getenv("DATABASE_PASSWORD");
        this.databaseName = System.getenv("DATABASE_NAME");
        this.databaseUrl = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        // Set up the connection pool
        this.hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(databaseUrl);
        hikariConfig.setUsername(databaseUser);
        hikariConfig.setPassword(databasePassword);
        this.dataSource = new HikariDataSource(hikariConfig);

        // Establish the database connection and instantiate DSLContext.
        try {
            dslContext = DSL.using(dataSource, SQLDialect.MYSQL);
            System.out.println("Successfully connected to the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DSLContext getDslContext() {
        return dslContext;
    }
}
