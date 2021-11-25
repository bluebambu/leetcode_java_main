package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class TreeSerializeLvl {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        Deque<TreeNode> que = new LinkedList<>();
        que.add(root);
        StringBuilder res = new StringBuilder();
        while (que.size() > 0) {
            TreeNode poll = que.poll();
            if(poll == null) {
                res.append("#");
                res.append(",");
                continue;
            }
            res.append(poll.val);
            res.append(",");
            que.add(poll.left);
            que.add(poll.right);
        }
        return res.toString().substring(0, res.length()-1);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return  null;
        }
        int i = data.indexOf(",");
        if (i== -1) {
            return new TreeNode(Integer.parseInt(data));
        }
        i += 1;
        String first = data.substring(0, i);
        TreeNode root = new TreeNode(Integer.parseInt(first));
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (i < data.length()) {
            // too tedious
        }
        return null;
    }

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
