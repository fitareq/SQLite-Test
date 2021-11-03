package com.airmoll.sqlitetest;

public class DataClass
{
    private String title;
    private String description;
    private String price;

    public DataClass(String title, String description, String price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
