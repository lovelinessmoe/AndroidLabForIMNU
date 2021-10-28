package xyz.javaee.myapplication.entity;

public class Product {

    private int avatar;
    private String name;
    private double money;
    private int levelOfAppearance;
    private double height;


    @Override
    public String toString() {
        return "Product{" +
                "avatar=" + avatar +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", levelOfAppearance=" + levelOfAppearance +
                ", height=" + height +
                '}';
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Product(int avatar, String name, double money, int levelOfAppearance, double height) {
        this.avatar = avatar;
        this.name = name;
        this.money = money;
        this.levelOfAppearance = levelOfAppearance;
        this.height = height;
    }
}

