package com.vintud;

import java.util.List;

public class Search {
    private int id;
    private String clothingType;
    private String size;
    private String color;
    private double minPrice;
    private double maxPrice;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Search{" +
                "clothingType='" + clothingType + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", userId=" + userId +
                '}';
    }
}
