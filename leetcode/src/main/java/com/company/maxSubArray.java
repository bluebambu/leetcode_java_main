package com.company;


// 53
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1; i<len; ++i){
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int curState = nums[0],
                res = nums[0];
        for(int i=1; i<len; ++i){
            curState = Math.max(nums[i], curState + nums[i]);
            res = Math.max(res, curState);
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
    }
}
