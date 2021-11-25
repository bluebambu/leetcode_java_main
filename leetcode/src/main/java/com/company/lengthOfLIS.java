package com.company;

import java.util.ArrayList;
import java.util.Arrays;

// 300
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <=1) return nums.length;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int res = 0;
        for(int i=1; i<len; ++i){
            for(int j=0; j<i; ++j){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                res = Math.max(res, dp[i]);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
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

        int[] nums = {1,3,6,7,9,4,10,5,6};
        int[] nums2 = {2, 3, 1, 2, 4, 3};
        int[] nums3 = {1, 2, 3, 4, 5};
        String s = "wreiuy/.,ASDFE";

        int i = new lengthOfLIS().lengthOfLIS(nums);
        System.out.println(i);
    }
}
