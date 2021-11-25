package com.company;

import java.util.Arrays;

// 370#
public class getModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] modification = new int[length];
        int[] res = new int[length];
        for(int[] u : updates){
            modification[u[0]] += u[2];
            if(u[1]+1 < length)
                modification[u[1]+1] -= u[2];
        }

//        System.out.println(Arrays.toString(modification));
        int incr = 0;
        for(int i=0; i<length; i++){
            incr += modification[i];
            res[i] = incr;
        }
        return res;
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

        int[] modifiedArray = new getModifiedArray().getModifiedArray(5, new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        });
        System.out.println(Arrays.toString(modifiedArray));

    }
}
