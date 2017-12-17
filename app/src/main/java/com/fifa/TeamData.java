package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyuanxu on 12/16/17.
 */

public class TeamData {
    private List<Team> teamList;
    private Map<Integer, Team> indexById;
    private Map<String, Team> indexByName;

    public TeamData() {
        this.teamList = new ArrayList<>();
    }

    public void addTeam(Team t) {
        teamList.add(t);
    }

    public void createIndex() {
        createIndexById();
        createIndexByName();
    }

    private void createIndexById() {
        indexById = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexById.put(teamList.get(i).getId(), teamList.get(i));
        }
    }

    private void createIndexByName() {
        indexByName = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexByName.put(String.valueOf(teamList.get(i).getLongName()), teamList.get(i));
        }
    }

    public Team getTeamById(int id) {
        if (!indexById.containsKey(id)) {
            return null;
        }
        return indexById.get(id);
    }

    public Team getTeamByName(String name) {
        if (!indexByName.containsKey(name)) {
            return null;
        }
        return indexByName.get(name);
    }

    public List<Team> getTeamList() {
        return teamList;
    }
}
