package org.example;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/Myorders", "postgres", "123412312")
                .load();
        flyway.migrate();
    }
}

