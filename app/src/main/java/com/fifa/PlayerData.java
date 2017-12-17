package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyuanxu on 12/16/17.
 */

public class PlayerData {
    private List<Player> playerList;
    private Map<Integer, Integer> idIndex;
    private Map<Integer, List<Integer>> teamIndex;

    public PlayerData() {
        playerList = new ArrayList<>();
    }

    public void add(Player player) {
        playerList.add(player);
    }

    public void createIndexWithId() {
        idIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            idIndex.put(playerList.get(i).getId(), i);
        }
    }

    public void createIndexWithTeam(TeamData teamData) {
        teamIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            String club = String.valueOf(playerList.get(i).getClub());
            Team team = teamData.getTeamByName(club);
            if (team == null) {
                continue;
            } else {
                if (!teamIndex.containsKey(team.getId())) {
                    teamIndex.put(team.getId(), new ArrayList<Integer>());
                }
                teamIndex.get(team.getId()).add(playerList.get(i).getId());
            }
        }
    }


    public List<Player> getPlayerList() {
        return playerList;
    }
}
