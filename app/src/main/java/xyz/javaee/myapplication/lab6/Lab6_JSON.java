package xyz.javaee.myapplication.lab6;

import java.io.Serializable;

public class Lab6_JSON implements Serializable {
    private String name;
    private int age;
    private String birthday;
    private String school;
    private String car;
    private String house;


    public Lab6_JSON() {
    }

    public Lab6_JSON(String name, int age, String birthday, String school, String car, String house) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.school = school;
        this.car = car;
        this.house = house;
    }

    @Override
    public String toString() {
        return
                "名字：'" + name + '\'' +
                        ", 年龄：" + age +
                        ", 生日：'" + birthday + '\'' +
                        ", 学校：'" + school + '\'' +
                        ", 汽车：'" + car + '\'' +
                        ", 房子：'" + house + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
