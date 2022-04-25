package com.bibliotehque;

import java.sql.ResultSet;
import java.util.ArrayList;

public class User implements BUR {
    private int id;
    private String prenom;
    private String nom;
    private String address;
    private String numTel;
    private String mail;
    private ArrayList<Rent> rents = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public void display() {
        System.out.println("Prénom: " + getPrenom());
        System.out.println("Nom: " + getNom());
        System.out.println("Adresse: " + getAddress());
        System.out.println("Tél: " + getNumTel());
        System.out.println("E-mail: " + getMail());
        for (int i = 0; i < getRents().size(); i++) {
            System.out.println("Livre " + i + 1 + ": " + getRents().get(i).getBook());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", address='" + address + '\'' +
                ", numTel='" + numTel + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
