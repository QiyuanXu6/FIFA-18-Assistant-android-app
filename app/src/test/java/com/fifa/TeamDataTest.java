package com.fifa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/17.
 */
public class TeamDataTest {
    PlayerData pd = new PlayerData();
    TeamData td = new TeamData();
    TeamData test = new TeamData();
    Player testPlayer = new Player(111,"John Smith",21, "testPhoto","US","flag",
            75, 80,"FCB","testLogo",10000,1000 );
    Team testTeam = new Team(1,11,111,"FCB","FCB");


    @Test
    public void addTeam() throws Exception {
        td.addTeam(testTeam);
        test.getTeamList().add(testTeam);
        assertTrue(td.equals(test));
    }

    @Test
    public void createIndex() throws Exception {
        pd.add(testPlayer);
        td.addTeam(testTeam);
        td.createIndex();
        pd.createIndex(td);
        boolean res = td.getTeamById(11)!=null && td.getTeamList()!=null
                && td.getTeamByName("FCB")!=null && td.getTeamNameByPrefix("F")!=null
                && td.getTeamLogoWithId(pd,11)!=null;
        assertTrue(res);
    }
}