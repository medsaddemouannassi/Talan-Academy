package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
    private int id;
    private String firstName;
    private String lastName;
    private String pseudo;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private int roleId;
    private boolean isConnected;
    private List<Integer> posted_announcements = new ArrayList<>();
    private List<Integer> favorite_announcements = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getPosted_announcements() {
        return posted_announcements;
    }

    public void setPosted_announcements(List<Integer> posted_announcements) {
        this.posted_announcements = posted_announcements;
    }

    public List<Integer> getFavorite_announcements() {
        return favorite_announcements;
    }

    public void setFavorite_announcements(List<Integer> favorite_announcements) {
        this.favorite_announcements = favorite_announcements;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
