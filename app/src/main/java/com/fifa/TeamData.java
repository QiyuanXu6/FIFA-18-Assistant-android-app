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
    private Map<Integer, Integer> indexById;
    private Map<String, Integer> indexByName;

    public TeamData() {
        this.teamList = new ArrayList<>();
    }

    public void addTeam(Team t) {
        teamList.add(t);
    }

    public void createIndexById() {
        indexById = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexById.put(teamList.get(i).getId(), i);
        }
    }

    public void createIndexByName() {
        indexByName = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            indexByName.put(String.valueOf(teamList.get(i).getLongName()), i);
        }
    }

    public Team getTeamById(int id) {
        return teamList.get(indexById.get(id));
    }
}
