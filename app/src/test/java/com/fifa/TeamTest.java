package com.fifa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/16.
 */
public class TeamTest {

    Team testTeam = new Team(1,11,111,"Chelsea","CHE");
    Team reseted = new Team(-1,-1,-1,"","");
    Team notReseted = new Team(1,-1,-1,"","");
    @Test
    public void toStringTest() throws Exception {
        String empty = null;
        String expected = "Team{" +
                "id=" + 1 +
                ", apiId=" + 11 +
                ", fifaId=" + 111 +
                ", longName='" + "Chelsea" + '\'' +
                ", shortName='" + "CHE" + '\'' +
                ", date='" + empty + '\'' +
                ", buildUpPlaySpeed=" + 0 +
                ", buildUpPlaySpeedClass='" + empty + '\'' +
                ", buildUpPlayDribbling=" + 0 +
                ", buildUpPlayDribblingClass='" + empty + '\'' +
                ", buildUpPlayPassing=" + 0 +
                ", buildUpPlayPassingClass='" + empty + '\'' +
                '}';
        System.out.println(testTeam);
        assertTrue(testTeam.toString().equals(expected));
    }


    @Test
    public void resetTeam1() throws Exception {
        testTeam.resetTeam();
        assertTrue(testTeam.equals(reseted));
    }

    @Test
    public void resetTeam2() throws Exception {
        testTeam.resetTeam();
        assertFalse(notReseted.equals(testTeam));
    }

    @Test
    public void resetTeam3() throws Exception {
        String test = "test";
        assertFalse(testTeam.equals(test));
    }


}