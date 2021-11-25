package com.company;

import java.util.HashMap;

import static com.company.Utils.getch;

public class trie {
    public class TrieNode {
        public HashMap<Character, TrieNode> child;
        public boolean isWord;

        public TrieNode(){
            child = new HashMap<>();
            isWord = false;
        }
    }

    TrieNode head = new TrieNode();

    public boolean add(String s){
        return add(s, 0, head);
    }

    private boolean add(String s, int i, TrieNode head) {
        if(i == s.length()){
            head.isWord = true;
            return true;
        }
        Character c = Character.valueOf(s.charAt(i));
        if(head.child.get(c) == null){
            head.child.put(c, new TrieNode());
        }
        return add(s, i+1, head.child.get(c));
    }

    public boolean check(String s){
        if(s==null) return false;
        return check(s, 0, head);
    }

    private boolean check(String s, int i, TrieNode n) {
        if(i > s.length()) return false;
        if(i == s.length()) return n.isWord;
        Character c = getch(s, i);
        if(n.child.get(c) == null)
            return false;
        return check(s, i+1, n.child.get(c));
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

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = {2, 3, 1, 2, 4, 3};
        int[] nums3 = {1, 2, 3, 4, 5};
        String s = "wreiuy/.,ASDFE";

        trie trie = new trie();
        trie.add(s);
        System.out.println(trie.check(s));
        System.out.println(trie.check("djj"));
    }
}
