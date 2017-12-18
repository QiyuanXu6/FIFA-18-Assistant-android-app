package com.fifa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/16.
 */
public class PlayerDataTest {
    PlayerData pd = new PlayerData();
    PlayerData test = new PlayerData();
    Player testPlayer = new Player(111,"John Smith",21, "testPhoto","US","flag",
            75, 80,"FCB","testLogo",10000,1000 );
    TeamData td = new TeamData();
    Team testTeam = new Team(1,11,111,"FCB","FCB");

    @Test
    public void add() throws Exception {
        test.getPlayerList().add(testPlayer);
        pd.add(testPlayer);
        assertTrue(test.equals(pd));
    }

    @Test
    public void createIndex() throws Exception {
        td.addTeam(testTeam);
        td.createIndex();
        pd.add(testPlayer);
        System.out.println(pd.getPlayerList().size());
        pd.createIndex(td);
        pd.getIdIndex();
        pd.getTeamIndex();
        pd.getNameList();
        pd.getPlayerList();
        boolean b1 = pd.getIdIndex()!=null;
        boolean b2 = pd.getTeamIndex()!=null;
        assertTrue(b1&&b2);
    }

}