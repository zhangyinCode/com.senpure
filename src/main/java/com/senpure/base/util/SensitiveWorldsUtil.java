package com.senpure.base.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by DZ on 2016-08-26 09:10
 */
public class SensitiveWorldsUtil {

    private static Logger log = LogManager.getLogger(SensitiveWorldsUtil.class);

    private static class Node implements Comparable<Node> {
        char value;
        Node left;
        Node right;
        Node parent;
        int height = 0;
        boolean end;

        public Node() {

        }

        public Node(char value) {
            this.value = value;
        }


        @Override
        public int compareTo(Node other) {
            return value > other.value ? 1 : value == other.value ? 0 : -1;
        }
    }

    //root
    private Node firstNode;


    public int toCode(char c) {


        return c;
    }

    private int height(Node node) {

        return node == null ? -1 : node.height;

    }

    public void insertFirst(char first) {


        firstNode = insertFirst(firstNode, first);

    }

    public Node insertFirst(Node node, char first) {

        if (node == null) {
            return new Node(first);
        }
        if (first < node.value) {
            node.left = insertFirst(node.left, first);
            if (height(node.left) - height(node.right) == 2) {
                if (first < node.left.value) {

                } else {
                }
            }
        } else if (first > node.value) {
            node.right = insertFirst(node.right, first);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }


    public static void addSensitiveWorlds(String worlds) {

        char first = worlds.charAt(0);


        for (int i = 0; i < worlds.length(); i++) {


            worlds.charAt(i);

        }


    }

    public static void main(String[] args) {

        char c = 110;
        System.out.println(c);

    }
}
