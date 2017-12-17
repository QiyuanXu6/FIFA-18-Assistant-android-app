package com.fifa;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is created to hold a team object.
 */

public class Team {
    //Team attributes
    private int id;
    private int apiId;
    private int fifaId;
    private String longName;
    private String shortName;
    private String date;
    private int buildUpPlaySpeed;
    private String buildUpPlaySpeedClass;
    private int buildUpPlayDribbling;
    private String buildUpPlayDribblingClass;
    private int buildUpPlayPassing;
    private String buildUpPlayPassingClass;

    /**
     * Constructor for this class
     * @param id id number of the team
     * @param apiId api id number of the team
     * @param fifaId fifa id of the team
     * @param longName long name of the team
     * @param shortName short name of the team
     */
    public Team(int id, int apiId, int fifaId, String longName, String shortName) {
        this.id = id;
        this.apiId = apiId;
        this.fifaId = fifaId;
        this.longName = longName;
        this.shortName = shortName;
    }

    /**
     * A method to produce a string to describe this team
     * @return a string of different attributes of the team.
     */
    @Override
    public String toString() {
        return "Team{" +
                "id=" + getId() +
                ", apiId=" + getApiId() +
                ", fifaId=" + getFifaId() +
                ", longName='" + getLongName() + '\'' +
                ", shortName='" + getShortName() + '\'' +
                ", date='" + getDate() + '\'' +
                ", buildUpPlaySpeed=" + getBuildUpPlaySpeed() +
                ", buildUpPlaySpeedClass='" + getBuildUpPlaySpeedClass() + '\'' +
                ", buildUpPlayDribbling=" + getBuildUpPlayDribbling() +
                ", buildUpPlayDribblingClass='" + getBuildUpPlayDribblingClass() + '\'' +
                ", buildUpPlayPassing=" + getBuildUpPlayPassing() +
                ", buildUpPlayPassingClass='" + getBuildUpPlayPassingClass() + '\'' +
                '}';
    }


    /**
     * getter and setter for instance variables
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getFifaId() {
        return fifaId;
    }

    public void setFifaId(int fifaId) {
        this.fifaId = fifaId;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBuildUpPlaySpeed() {
        return buildUpPlaySpeed;
    }

    public void setBuildUpPlaySpeed(int buildUpPlaySpeed) {
        this.buildUpPlaySpeed = buildUpPlaySpeed;
    }

    public String getBuildUpPlaySpeedClass() {
        return buildUpPlaySpeedClass;
    }

    public void setBuildUpPlaySpeedClass(String buildUpPlaySpeedClass) {
        this.buildUpPlaySpeedClass = buildUpPlaySpeedClass;
    }

    public int getBuildUpPlayDribbling() {
        return buildUpPlayDribbling;
    }

    public void setBuildUpPlayDribbling(int buildUpPlayDribbling) {
        this.buildUpPlayDribbling = buildUpPlayDribbling;
    }

    public String getBuildUpPlayDribblingClass() {
        return buildUpPlayDribblingClass;
    }

    public void setBuildUpPlayDribblingClass(String buildUpPlayDribblingClass) {
        this.buildUpPlayDribblingClass = buildUpPlayDribblingClass;
    }

    public int getBuildUpPlayPassing() {
        return buildUpPlayPassing;
    }

    public void setBuildUpPlayPassing(int buildUpPlayPassing) {
        this.buildUpPlayPassing = buildUpPlayPassing;
    }

    public String getBuildUpPlayPassingClass() {
        return buildUpPlayPassingClass;
    }

    public void setBuildUpPlayPassingClass(String buildUpPlayPassingClass) {
        this.buildUpPlayPassingClass = buildUpPlayPassingClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (apiId != team.apiId) return false;
        if (fifaId != team.fifaId) return false;
        if (buildUpPlaySpeed != team.buildUpPlaySpeed) return false;
        if (buildUpPlayDribbling != team.buildUpPlayDribbling) return false;
        if (buildUpPlayPassing != team.buildUpPlayPassing) return false;
        if (longName != null ? !longName.equals(team.longName) : team.longName != null)
            return false;
        if (shortName != null ? !shortName.equals(team.shortName) : team.shortName != null)
            return false;
        if (date != null ? !date.equals(team.date) : team.date != null) return false;
        if (buildUpPlaySpeedClass != null ? !buildUpPlaySpeedClass.equals(team.buildUpPlaySpeedClass) : team.buildUpPlaySpeedClass != null)
            return false;
        if (buildUpPlayDribblingClass != null ? !buildUpPlayDribblingClass.equals(team.buildUpPlayDribblingClass) : team.buildUpPlayDribblingClass != null)
            return false;
        return buildUpPlayPassingClass != null ? buildUpPlayPassingClass.equals(team.buildUpPlayPassingClass) : team.buildUpPlayPassingClass == null;
    }

    public void resetTeam() {
        setApiId(-1);
        setLongName("");
        setShortName("");
        setId(-1);
        setFifaId(-1);
        setDate(null);
        setBuildUpPlayDribblingClass(null);
        setBuildUpPlaySpeedClass(null);
        setBuildUpPlayPassingClass(null);
        setBuildUpPlayDribbling(0);
        setBuildUpPlaySpeed(0);
        setBuildUpPlayPassing(0);
    }

}
