package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
public class PostOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (Connection connection = DatabaseConnection.getConnection()) {
            String orderIDParam = request.getParameter("orderID");
            String dateCreated = request.getParameter("dateCreated");
            String status = request.getParameter("status");
            String customerIDParam = request.getParameter("customerID");
            String employeeIDParam = request.getParameter("employeeID");
            int orderID = (orderIDParam != null) ? Integer.parseInt(orderIDParam) : 0;
            int customerID = (customerIDParam != null) ? Integer.parseInt(customerIDParam) : 0;
            int employeeID = (employeeIDParam != null) ? Integer.parseInt(employeeIDParam) : 0;
            ConsoleCRUD.addOrderPost(connection, orderID, dateCreated, status, customerID, employeeID);
            response.getWriter().println("Order created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating order.");
        }
    }
}