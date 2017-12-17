package com.fifa;

import java.io.InputStreamReader;

/**
 * Created by qiyuanxu on 12/16/17.
 */

public class FifaDataController {
    private PlayerData playerData;
    private TeamData teamData;
    private InputStreamReader playerSteam;
    private InputStreamReader teamStream;
    private InputStreamReader teamAttrStream;

    public FifaDataController(PlayerData playerData, TeamData teamData, InputStreamReader playerSteam, InputStreamReader teamStream, InputStreamReader teamAttrStream) {
        this.playerData = playerData;
        this.teamData = teamData;
        this.playerSteam = playerSteam;
        this.teamStream = teamStream;
        this.teamAttrStream = teamAttrStream;
    }

    public void startReading() {
        TeamReader teamReader = new TeamReader(teamStream, teamAttrStream, teamData);
        teamReader.read();
        PlayerReader playerReader = new PlayerReader(playerSteam, playerData, teamData);
        playerReader.read();
    }


}
