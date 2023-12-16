package org.example;
import java.util.Date;

public class Order {
    private int orderID;
    private String dateCreated;
    private String status;
    private int customerID;
    private int employeeID;
    public Order(int orderID, String status,String dateCreated, int customerID, int employeeID) {
        this.orderID = orderID;
        this.status = status;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.dateCreated = dateCreated;
    }
    public Order() {
    }

    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                '}';
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
