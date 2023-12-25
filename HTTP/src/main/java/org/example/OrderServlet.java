package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (Connection connection = DatabaseConnection.getConnection()) {
            List<String> allOrders = ConsoleCRUD.getAllOrders(connection);
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            for (String order : allOrders) {
                out.println("<p>" + order + "</p>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка при получении данных из базы данных");
        }
    }
}
