package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int v) {
        val = v;
    }
    public TreeNode(int a, TreeNode l, TreeNode r) {
        val = a;
        left = l;
        right = r;
    }

    public List<Integer> preOrder() {
        ArrayList<Integer> res = new ArrayList<>();
        pre(this, res);
        return res;
    }
    private void pre(TreeNode node,  List<Integer> res) {
        if(node == null) {
            return;
        }

        res.add(node.val);
        pre(node.left, res);
        pre(node.right, res);
    }

    public List<Integer> lvlOrder() {
        ArrayList<Integer> res = new ArrayList<>();
        lvl(this, res);
        return res;
    }
    private void lvl(TreeNode node,  List<Integer> res) {
        if(node == null) {
            return;
        }

        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(node);
        while (que.size()>0) {
            TreeNode head = que.remove();
            res.add(head.val);
            if (head.left != null)
                que.add(head.left);
            if (head.right != null)
                que.add(head.right);
        }
    }

    public void preOrder2(){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            if (pop == null) {
                sb.append("#");
                sb.append(",");
                continue;
            }
            sb.append(pop.val);
            sb.append(",");
            stack.push(pop.right);
            stack.push(pop.left);
        }
        System.out.println(sb.toString());
    }

    public void inOrder2(){
        Stack<TreeNode> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        TreeNode mostLeft = this;
        while (stk.size()>0 || mostLeft != null){
            while (mostLeft != null){
                stk.push(mostLeft);
                mostLeft = mostLeft.left;
            }

            TreeNode top = stk.pop();
            sb.append(top.val);
            sb.append(",");
            if (top.right != null){
                mostLeft = top.right;
            }
        }
        System.out.println(sb.toString());
    }

    public void postOrder2(){
        Stack<TreeNode> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        TreeNode mostLeft = this;
        TreeNode prev = null;

        while (stk.size()>0 || mostLeft!=null){
            while (mostLeft != null) {
                stk.push(mostLeft);
                mostLeft = mostLeft.left;
            }

            TreeNode top = stk.peek();
            if(prev == top.right || top.right == null) {
                stk.pop();
                sb.append(top.val);
                sb.append(",");
                prev = top;
            } else {
                mostLeft = top.right;
            }
        }
        System.out.println(sb.toString());
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


        a.inOrder2();
        a.postOrder2();
    }
}
