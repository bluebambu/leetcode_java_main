package com.company;

public class minWindowSubseq {
    public String minWindow(String s1, String s2) {
        int i1=0, j1=0, i2=0;
        int res = s1.length() + 1, subLen = 0;
        while (true){
            while (j1<s1.length()){
                if(i2==s2.length())
                    break;

            }
        }
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
    }
}
