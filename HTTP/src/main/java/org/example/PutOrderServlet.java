package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
public class PutOrderServlet extends HttpServlet {
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (Connection connection = DatabaseConnection.getConnection()) {
            String orderIDParam = request.getParameter("orderID");
            String newStatus = request.getParameter("newStatus");
            int orderID = (orderIDParam != null) ? Integer.parseInt(orderIDParam) : 0;
            ConsoleCRUD.updateOrderPut(connection, orderID, newStatus);
            response.getWriter().println("Order updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating order.");
        }
    }
}
