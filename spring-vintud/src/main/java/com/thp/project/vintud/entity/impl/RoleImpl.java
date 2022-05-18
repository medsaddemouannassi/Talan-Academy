package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.Role;

public class RoleImpl implements Role {
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
