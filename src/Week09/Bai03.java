package Week09;

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Bai03 {
    public static Node lca(Node root, int v1, int v2) {
        Node curr = root;

        while (curr != null) {
            if (v1 < curr.data && v2 < curr.data) {
                curr = curr.left;
            } else if (v1 > curr.data && v2 > curr.data) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }
}