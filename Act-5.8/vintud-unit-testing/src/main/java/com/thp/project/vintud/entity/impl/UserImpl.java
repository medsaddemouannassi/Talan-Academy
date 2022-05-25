package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "users")
public class UserImpl implements User, Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String pseudo;
    private String email;
    private String password;
    @Column(name = "phone")
    private String phoneNumber;
    private String address;
    @ManyToOne(cascade=CascadeType.ALL) @JoinColumn( name="role_id")
    private RoleImpl role_id;
    @Column(name = "is_connected")
    private boolean isConnected;
    @OneToMany( targetEntity=AnnouncementImpl.class, mappedBy="user" ) @Transient
    private List<AnnouncementImpl> posted_announcements = new ArrayList<>();

    @OneToMany( targetEntity=Favorite.class, mappedBy="user" ) @Transient
    private List<Favorite> favorite_announcements = new ArrayList<>();

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public RoleImpl getRole_id() {
        return role_id;
    }

    public void setRole_id(RoleImpl role_id) {
        this.role_id = role_id;
    }

    public List<AnnouncementImpl> getPosted_announcements() {
        return posted_announcements;
    }

    public void setPosted_announcements(List<AnnouncementImpl> posted_announcements) {
        this.posted_announcements = posted_announcements;
    }

    public List<Favorite> getFavorite_announcements() {
        return favorite_announcements;
    }

    public void setFavorite_announcements(List<Favorite> favorite_announcements) {
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
                "id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", roleId=" + role_id +
                '}';
    }
}
