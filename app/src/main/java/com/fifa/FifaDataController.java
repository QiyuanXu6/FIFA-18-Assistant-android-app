package com.fifa;

import java.io.InputStreamReader;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is built to manage the whole data reading process
 */

public class FifaDataController {

    //Variables of data
    private PlayerData playerData;
    private TeamData teamData;

    //Variables of Passed in streams
    private InputStreamReader playerSteam;
    private InputStreamReader teamStream;
    private InputStreamReader teamAttrStream;

    /**
     * Constructor method to pass all necessary values in.
     * @param playerData object to manage all player data
     * @param teamData  object to manage all team data
     * @param playerSteam player data stream
     * @param teamStream  team data stream
     * @param teamAttrStream team attribute data stream
     */
    public FifaDataController(PlayerData playerData, TeamData teamData, InputStreamReader playerSteam, InputStreamReader teamStream, InputStreamReader teamAttrStream) {
        this.playerData = playerData;
        this.teamData = teamData;
        this.playerSteam = playerSteam;
        this.teamStream = teamStream;
        this.teamAttrStream = teamAttrStream;
    }

    /**
     * This method is built to read all data streams into playerData and teamData
     */
    public void startReading() {
        TeamReader teamReader = new TeamReader(teamStream, teamAttrStream, teamData);
        teamReader.read();
        PlayerReader playerReader = new PlayerReader(playerSteam, playerData, teamData);
        playerReader.read();
    }


}
