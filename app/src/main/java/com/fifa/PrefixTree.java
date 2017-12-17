package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyuanxu on 12/16/17.
 * This is class for the data structure of prefix tree
 */

public class PrefixTree<T> {

    private Node root;

    /**
     * inner class Node represents Tree Node
     */
    private class Node {
        private T obj;
        private Map<Character, Node> children;

        @SuppressWarnings("unchecked")
        public Node (T thing) {
            this.obj = thing;
            children = new HashMap<>(26);
        }
    }

    /**
     * Constructor method for prefix tree;
     */
    public PrefixTree() {
        this.root = new Node(null);
    }

    /**
     * insert a node with object of type T into the tree
     * @param key string key of the object, which is the name of the team
     * @param obj object is the thing we store in the tree node
     */
    public void insert(String key, T obj) {
        key = key.toLowerCase();
        Node cur = root;
        for (char c: key.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    cur.children.put(c, new Node(null));
                    cur = cur.children.get(c);
                }
            }
        }
        cur.obj = obj;
    }

    /**
     * Method to find object with a prefix key
     * @param key prefix key of the search query
     * @return list of objects with the prefix key
     */
    public List<T> findPrefix(String key) {
        key = key.toLowerCase();
        Node cur = root;
        List<T> res = new ArrayList<>();
        for (char c: key.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (!cur.children.containsKey(c)) {
                    return res;
                }
                cur = cur.children.get(c);
            }
        }
        traversal(res, cur);
        return res;
    }

    /**
     * Method to recursively find all objects stored in the node's subtree
     * @param res list of objects
     * @param cur current node being visiting
     */
    private void traversal(List<T> res, Node cur) {

        if (cur == null) return;

        if (cur.obj != null) {
            res.add(cur.obj);
        }
        for (Map.Entry<Character, Node> en: cur.children.entrySet()) {
            traversal(res, en.getValue());
        }
    }
}
