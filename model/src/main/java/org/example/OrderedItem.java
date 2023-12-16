package org.example;
public class OrderedItem {
    private int orderedItemID;
    private int orderID;
    private int productID;
    private int quantity;
    private double totalAmount;

    public int getOrderedItemID() {
        return orderedItemID;
    }

    public void setOrderedItemID(int orderedItemID) {
        this.orderedItemID = orderedItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}