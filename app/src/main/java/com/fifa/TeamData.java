package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private PrefixTree<Team> prefixTree;

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
        createPrefixTree();
    }

    /**
     * Method to create a hash map of team id and team object
     */
    private void createIndexById() {
        indexById = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexById.put(teamList.get(i).getApiId(), teamList.get(i));
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
     * Method to create a prefix tree based on team name wrods to realize quick vague query of team name
     */
    private void createPrefixTree() {
        prefixTree = new PrefixTree<>();
        for (int i = 0; i < teamList.size(); i++) {
            String[] words = teamList.get(i).getLongName().split(" ");
            for (String word: words) {
                prefixTree.insert(word, teamList.get(i));
            }
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
     * Use prefix tree to find a team list
     * @param pre prefix of the name
     * @return list of target teams
     */
    public List<Team> getTeamsByPrefix(String pre) {
        List<Team> teams= prefixTree.findPrefix(pre);
        Set<Team> set = new HashSet<>(teams);
        List<Team> res = new ArrayList<>(set);
        return res;
    }

    /**
     * User prefix tree to get all team names
     * @param pre prefix of the team long or short name
     * @return list of team full names
     */
    public List<String> getTeamNameByPrefix(String pre) {
        List<Team> teams= getTeamsByPrefix(pre);
        List<String> res = new ArrayList<>();
        for (Team t: teams) {
            res.add(t.getLongName());
        }
        return res;
    }

    /**
     * getter method for teamList object
     * @return list of team objects
     */
    public List<Team> getTeamList() {
        return teamList;
    }

    /**
     * get the name list of all teams
     * @return
     */
    public ArrayList<String> getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Team t: teamList) {
            nameList.add(t.getLongName());
        }
        return nameList;
    }

    public String getTeamLogoWithId(PlayerData playerData, int id) {
        Map<Integer, List<Player>> map = playerData.getTeamIndex();
        if (!map.containsKey(id)) {
            return "";
        } else {
            return map.get(id).get(0).getClubLogo();
        }
    }
}
