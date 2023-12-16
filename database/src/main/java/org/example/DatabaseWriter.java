package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class DatabaseWriter {

    public static void insertOrders(Connection connection, List<Order> orders) throws SQLException {
        String insertQuery = "INSERT INTO public.\"OrdersList\" (\"orderID\", \"dataCreated\", \"status\", \"customerID\", \"employeeID\") " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            for (Order order : orders) {
                statement.setInt(1, order.getOrderID());
                statement.setString(2, order.getDateCreated());
                statement.setString(3, order.getStatus());
                statement.setInt(4, order.getCustomerID());
                statement.setInt(5, order.getEmployeeID());
                statement.executeUpdate();
            }
        }
    }
}
