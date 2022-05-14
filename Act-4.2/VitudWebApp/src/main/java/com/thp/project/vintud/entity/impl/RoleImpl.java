package com.thp.project.vintud.entity.impl;

public class RoleImpl {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleImpl{" +
                ", name='" + name + '\'' +
                '}';
    }
}
