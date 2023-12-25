package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteOrderServlet extends HttpServlet {
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (Connection connection = DatabaseConnection.getConnection()) {
            String orderIDParam = request.getParameter("orderID");
            int orderID = (orderIDParam != null) ? Integer.parseInt(orderIDParam) : 0;
            ConsoleCRUD.deleteOrderDel(connection, orderID);
            PrintWriter out = response.getWriter();
            out.println("Order deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error deleting order: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting order.");
        }

}
}
