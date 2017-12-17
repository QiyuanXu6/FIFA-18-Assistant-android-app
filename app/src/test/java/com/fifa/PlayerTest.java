package com.fifa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/16.
 */
public class PlayerTest {

    Player testPlayer = new Player(111,"John Smith",21, "testPhoto","US","flag",
            75, 80,"FCB","testLogo",10000,1000 );
    Player reseted = new Player(-1,"",-1, "","","",
            -1, -1,"","",-1,-1);
    Player notReseted = new Player(1,"",-1, "","","",
            -1, -1,"","",-1,-1);


    @Test
    public void toStringTest() throws Exception {
        String expected = "Player{" +
                "id=" + "111" +
                ", name='" + "John Smith" + '\'' +
                ", age=" + "21" +
                ", photo='" + "testPhoto" + '\'' +
                ", nationality='" + "US" + '\'' +
                ", flag='" + "flag" + '\'' +
                ", overall=" + "75" +
                ", potential=" + "80" +
                ", club='" + "FCB" + '\'' +
                ", clubLogo='" + "testLogo" + '\'' +
                ", value=" + "10000" +
                ", wage=" + "1000" +
                '}';
        assertTrue(testPlayer.toString().equals(expected));
    }


    @Test
    public void resetPlayer1() throws Exception {
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