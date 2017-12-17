package com.fifa;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by caohai on 2017/12/17.
 */
public class PrefixTreeTest {

    PrefixTree<String> tree = new PrefixTree<>();


    @Test
    public void insert() throws Exception {
        tree.insert("testkey","testobj");
        List<String> res = tree.findPrefix("testkey");
        assertNotNull(res);
    }

    @Test
    public void findPrefix() throws Exception {
        tree.insert("testkey","testobj");
        List<String> res = tree.findPrefix("testkey");
        assertTrue(res.contains("testobj"));

    }

}