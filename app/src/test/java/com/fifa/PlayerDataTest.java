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

    @Test
    public void add() throws Exception {
        test.getPlayerList().add(testPlayer);
        pd.add(testPlayer);
        assertTrue(test.equals(pd));
    }

    @Test
    public void createIndex() throws Exception {
    }

}