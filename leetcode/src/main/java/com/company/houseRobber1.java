package com.company;

import java.util.ArrayList;

// 198
public class houseRobber1 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        // dp[i] = max( dp[i-1], dp[i-2] + nums[i]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<len; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
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
    }
}
