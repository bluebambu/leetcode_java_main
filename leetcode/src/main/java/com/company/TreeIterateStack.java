package com.company;

public class TreeIterateStack {

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 5, 8};
        TreeNode a = new TreeNode(0),
                b = new TreeNode(1),
                c = new TreeNode(2),
                d = new TreeNode(3),
                e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        /**
         *               0
         *         1           2
         *     3            4
         */

    }
}
