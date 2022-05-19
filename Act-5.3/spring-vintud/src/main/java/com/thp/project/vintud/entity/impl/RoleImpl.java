package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.Role;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleImpl implements Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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
