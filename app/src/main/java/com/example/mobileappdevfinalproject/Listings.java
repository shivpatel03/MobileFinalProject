package com.example.mobileappdevfinalproject;


public class Listings {
    private int id;
    private String title;
    private int userId;
    private String description;
    private double cost;
    private String condition;

    public Listings (int id, String title, int userId, String description, double cost, String condition) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.description = description;
        this.cost = cost;
        this.condition = condition;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public String getCondition() {
        return condition;
    }

}
