package xyz.javaee.myapplication.entity;

import java.io.Serializable;

public class People implements Serializable {
    private double money;
    private int levelOfAppearance;
    private double height;
    private String username;
    private String password;

    public int buy(Double money) {
        if (this.money >= money) {
            this.money -= money;
            return 1;
        } else {
            return -1;
        }
    }

    public void beautiful(int levelOfAppearance) {
        this.levelOfAppearance += levelOfAppearance;
    }
    public void growTaller(double height) {
        this.height += height;
    }




    @Override
    public String toString() {
        return "People{" +
                "money=" + money +
                ", levelOfAppearance=" + levelOfAppearance +
                ", height=" + height +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public People() {
    }

    public People(double money, int levelOfAppearance, double height, String username, String password) {
        this.money = money;
        this.levelOfAppearance = levelOfAppearance;
        this.height = height;
        this.username = username;
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getLevelOfAppearance() {
        return levelOfAppearance;
    }

    public void setLevelOfAppearance(int levelOfAppearance) {
        this.levelOfAppearance = levelOfAppearance;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
