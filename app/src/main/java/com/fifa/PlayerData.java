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
    private Map<Integer, Player> idIndex;
    private Map<Integer, List<Player>> teamIndex;

    public PlayerData() {
        playerList = new ArrayList<>();
    }

    public void add(Player player) {
        playerList.add(player);
    }

    public void createIndex(TeamData teamData) {
        createIndexWithId();
        createIndexWithTeam(teamData);
    }

    private void createIndexWithId() {
        idIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            idIndex.put(playerList.get(i).getId(), playerList.get(i));
        }
    }

    private void createIndexWithTeam(TeamData teamData) {
        teamIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            String club = String.valueOf(playerList.get(i).getClub());
            Team team = teamData.getTeamByName(club);
            if (team == null) {
                continue;
            } else {
                if (!teamIndex.containsKey(team.getId())) {
                    teamIndex.put(team.getId(), new ArrayList<Player>());
                }
                teamIndex.get(team.getId()).add(playerList.get(i));
            }
        }
    }


    public List<Player> getPlayerList() {
        return playerList;
    }
}
