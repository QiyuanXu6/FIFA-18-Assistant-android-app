package com.example.lizhao.myfirstapplication;

/**
 * Created by lizhao on 2017/12/13.
 */

public class Player {
    private int id;
    private String name;
    private int age;
    private String country;
    private String photo;

    public Player(int id, String name, String country, int age, String photo) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.photo = photo;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
