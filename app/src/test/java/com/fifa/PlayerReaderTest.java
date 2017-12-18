package com.fifa;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/17.
 */
public class PlayerReaderTest {


    @Test
    public void read() throws Exception {
        PlayerData pd = new PlayerData();
        TeamData td = new TeamData();
        InputStream in = new FileInputStream("PlayerPersonalData2.0.csv");
        InputStreamReader playerStream = new InputStreamReader(in);
        PlayerReader pr = new PlayerReader(playerStream,pd,td);
        td.createIndex();
        pr.read();
        assertTrue(pd.getPlayerList()!=null && td.getTeamList()!=null);
    }

}