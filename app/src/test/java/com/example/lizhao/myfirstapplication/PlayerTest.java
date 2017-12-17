package com.example.lizhao.myfirstapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/16.
 */
public class PlayerTest {

    Player testPlayer = new Player(111,"John Smith", "South Africa",21,"testPhoto",75);
    Player reseted = new Player(-1,"","",-1,"",-1);
    Player notReseted = new Player(1,"","",-1,"",-1);
    @Test
    public void toStringTest() throws Exception {
        String expected = "Player ID: 111 name: John Smith country: South Africa age: 21 overall: 75 photo: testPhoto";
        assertTrue(testPlayer.toString().equals(expected));
    }

    @Test
    public void resetPlayerTest1() throws Exception {
        testPlayer.resetPlayer();
        assertTrue(testPlayer.equals(reseted));
    }

    @Test
    public void resetPlayerTest2() throws Exception {
        testPlayer.resetPlayer();
        assertFalse(notReseted.equals(testPlayer));
    }

    @Test
    public void resetPlayerTest3() throws Exception {
        String test = "test";
        assertFalse(testPlayer.equals(test));
    }

}