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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (age != player.age) return false;
        if (overall != player.overall) return false;
        if (potential != player.potential) return false;
        if (value != player.value) return false;
        if (wage != player.wage) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (photo != null ? !photo.equals(player.photo) : player.photo != null) return false;
        if (nationality != null ? !nationality.equals(player.nationality) : player.nationality != null)
            return false;
        if (flag != null ? !flag.equals(player.flag) : player.flag != null) return false;
        if (club != null ? !club.equals(player.club) : player.club != null) return false;
        return clubLogo != null ? clubLogo.equals(player.clubLogo) : player.clubLogo == null;
    }

    /**
     * This method reset a Player object, all integer numbers to -1, all string fields to empty String
     */
    public void resetPlayer() {
        setAge(-1);
        setClub("");
        setClubLogo("");
        setFlag("");
        setFlag("");
        setId(-1);
        setName("");
        setOverall(-1);
        setPhoto("");
        setPotential(-1);
        setValue(-1);
        setWage(-1);
    }

}
