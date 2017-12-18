package com.fifa;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/16.
 */
public class FifaDataControllerTest {
    @Test
    public void startReading() throws Exception {
        PlayerData pd = new PlayerData();
        TeamData td = new TeamData();
        InputStream in = new FileInputStream("PlayerPersonalData2.0.csv");
        InputStreamReader playerStream = new InputStreamReader(in);
        InputStream in1 = new FileInputStream("Team.csv");
        InputStream in2 = new FileInputStream("Team_Attributes.csv");
        InputStreamReader teamStream = new InputStreamReader(in1);
        InputStreamReader teamAttrStream = new InputStreamReader(in2);
        FifaDataController fdc = new FifaDataController(pd,td,playerStream,teamStream,teamAttrStream);
        fdc.startReading();
        assertTrue(pd.getPlayerList()!=null&&td.getTeamList()!=null);
    }

}