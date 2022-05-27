package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class RoleImpl implements Role, Serializable {
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

    public RoleImpl(int role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public RoleImpl() {
    }

    @Override
    public String toString() {
        return "RoleImpl{" +
                ", name='" + name + '\'' +
                '}';
    }
}
