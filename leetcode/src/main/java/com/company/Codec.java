package com.company;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val +","
                +serialize(root.left)+","
                +serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] wrapInt = {0};
        return dfs(data, wrapInt);
    }
    private TreeNode dfs(String data, int[] idx) {
        int sepPos = data.indexOf(",", idx[0]);
        if (sepPos == -1)
            sepPos = data.length();
        String cur = data.substring(idx[0], sepPos);
        idx[0] = sepPos + 1;
        if(cur.equals("#"))
            return null;

        TreeNode c = new TreeNode(Integer.parseInt(cur));
        c.left = dfs(data, idx);
        c.right = dfs(data, idx);
        return c;
    }

    public static void main(String[] args) {
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

        Codec codec = new Codec();
        String serialize = codec.serialize(a);
        System.out.println(serialize);
        System.out.println();
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize.preOrder());
    }
}
