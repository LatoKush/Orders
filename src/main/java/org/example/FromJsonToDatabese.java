package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FromJsonToDatabese {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Чтение данных из JSON
            List<Order> orders = JsonProcessor.readFromJson("orders.json");

            // Запись данных в базу данных
            if (orders != null) {
                DatabaseWriter.insertOrders(connection, orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
