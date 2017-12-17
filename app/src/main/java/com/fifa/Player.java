package com.fifa;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is created to hold values of one single player.
 */

public class Player {

    private int id;
    private String name;
    private int age;
    private String photo;
    private String nationality;
    private String flag;
    private int overall;
    private int potential;
    private String club;
    private String clubLogo;
    private int value;
    private int wage;

    public Player(int id, String name, int age, String photo, String nationality, String flag, int overall, int potential, String club, String clubLogo, int value, int wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.nationality = nationality;
        this.flag = flag;
        this.overall = overall;
        this.potential = potential;
        this.club = club;
        this.clubLogo = clubLogo;
        this.value = value;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", photo='" + getPhoto() + '\'' +
                ", nationality='" + getNationality() + '\'' +
                ", flag='" + getFlag() + '\'' +
                ", overall=" + getOverall() +
                ", potential=" + getPotential() +
                ", club='" + getClub() + '\'' +
                ", clubLogo='" + getClubLogo() + '\'' +
                ", value=" + getValue() +
                ", wage=" + getWage() +
                '}';
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getPotential() {
        return potential;
    }

    public void setPotential(int potential) {
        this.potential = potential;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
}
