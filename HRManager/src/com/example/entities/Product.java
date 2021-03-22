package com.example.entities;

public class Product {
    private int ID;
    private String Name;
    private String Price;
    private String Amount;
    private String Details;

    public Product(){

    }

    public Product(int ID, String name, String price, String amount, String details) {
        this.ID = ID;
        Name = name;
        Price = price;
        Amount = amount;
        Details = details;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
