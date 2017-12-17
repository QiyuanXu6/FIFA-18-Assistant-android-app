package com.fifa;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is created to hold values of one single player.
 */

public class Player {

    //Attributes of players
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

    /**
     * Constructor method to pass attributes in
     * @param id id number of player
     * @param name name of the player
     * @param age age of the player
     * @param photo photo URL of the player
     * @param nationality nationality of the player
     * @param flag flag picture URL of the nationality
     * @param overall overall score of the player, full score is 100
     * @param potential potential score of the player
     * @param club club name of the player
     * @param clubLogo club logo URL of the player
     * @param value player's estimate price
     * @param wage player's wage in year
     */
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

    /**
     * This method is to produce a string of this player attributes
     * @return a string of attributes of player
     */
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", nationality='" + nationality + '\'' +
                ", flag='" + flag + '\'' +
                ", overall=" + overall +
                ", potential=" + potential +
                ", club='" + club + '\'' +
                ", clubLogo='" + clubLogo + '\'' +
                ", value=" + value +
                ", wage=" + wage +
                '}';
    }

    /**
     *
     * Get and set method for private attributes
     */
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
