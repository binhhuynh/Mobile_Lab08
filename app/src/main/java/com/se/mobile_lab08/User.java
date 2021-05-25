package com.se.mobile_lab08;

public class User {
    public String fullName;
    public String email;
    public int nSmile;
    public int nBored;
    public int nSad;

    public User() {
    }

    public User(String fullName, String email, int nSmile, int nBored, int nSad) {
        this.fullName = fullName;
        this.email = email;
        this.nSmile = nSmile;
        this.nBored = nBored;
        this.nSad = nSad;
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getnSmile() {
        return nSmile;
    }

    public int getnBored() {
        return nBored;
    }

    public int getnSad() {
        return nSad;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", nSmile=" + nSmile +
                ", nBored=" + nBored +
                ", nSad=" + nSad +
                '}';
    }
}
