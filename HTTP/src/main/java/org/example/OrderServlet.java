package org.example;

import org.example.ConsoleCRUD;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("orderId");
        if (orderId != null) {
            PrintWriter out = response.getWriter();
            out.println("Data for orderId " + orderId);
        } else {
            PrintWriter out = response.getWriter();
            out.println("All orders");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data = request.getParameter("data");
        PrintWriter out = response.getWriter();
        out.println("Order created");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("orderId");
        String newData = request.getParameter("newData");
        PrintWriter out = response.getWriter();
        out.println("Order updated");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("orderId");
        PrintWriter out = response.getWriter();
        out.println("Order deleted");
    }
}

