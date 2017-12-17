package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is create to store and manage team data
 */

public class TeamData {

    //Team list contains all team objects
    private List<Team> teamList;

    //Hashmaps to increase query speed
    private Map<Integer, Team> indexById;
    private Map<String, Team> indexByName;

    /**
     * Constructor for this class
     */
    public TeamData() {
        this.teamList = new ArrayList<>();
    }

    /**
     * Method to add a team object to this class
     * @param t team object to be added in
     */
    public void addTeam(Team t) {
        teamList.add(t);
    }

    /**
     * Method to create all hash maps
     */
    public void createIndex() {
        createIndexById();
        createIndexByName();
    }

    /**
     * Method to create a hash map of team id and team object
     */
    private void createIndexById() {
        indexById = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexById.put(teamList.get(i).getId(), teamList.get(i));
        }
    }

    /**
     * Method to create a hash map of team name and team object
     */
    private void createIndexByName() {
        indexByName = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexByName.put(String.valueOf(teamList.get(i).getLongName()), teamList.get(i));
        }
    }

    /**
     * Method to get a team object with team id
     * @param id id of the team which you are looking for
     * @return target team object otherwise null if not found
     */
    public Team getTeamById(int id) {
        if (!indexById.containsKey(id)) {
            return null;
        }
        return indexById.get(id);
    }

    /**
     * Method to get a team object with team id
     * @param name name of the team which you are looking for
     * @return target team object otherwise null if not found
     */
    public Team getTeamByName(String name) {
        if (!indexByName.containsKey(name)) {
            return null;
        }
        return indexByName.get(name);
    }

    /**
     * getter method for teamList object
     * @return list of team objects
     */
    public List<Team> getTeamList() {
        return teamList;
    }

    public ArrayList<String> getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Team t: teamList) {
            nameList.add(t.getLongName());
        }
        return nameList;
    }
}
