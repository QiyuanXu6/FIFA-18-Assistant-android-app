package com.fifa;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/17.
 */
public class TeamReaderTest {
    @Test
    public void read() throws Exception {
        PlayerData pd = new PlayerData();
        TeamData td = new TeamData();
        InputStream in1 = new FileInputStream("Team.csv");
        InputStream in2 = new FileInputStream("Team_Attributes.csv");
        InputStreamReader teamStream = new InputStreamReader(in1);
        InputStreamReader teamAttrStream = new InputStreamReader(in2);
        TeamReader tr = new TeamReader(teamStream,teamAttrStream,td);
        pd.createIndex(td);
        tr.read();
        assertTrue(td.getTeamList()!=null);

    }

}