package com.company;

public class MinimumSizeSubarraySum{
    public int minSubArrayLen(int target, int[] nums) {
        // [, ) range
        int i=0, j=1, sum = nums[0];
        int res = nums.length + 1;
        while (true){
            while (j<nums.length && sum < target){
                sum += nums[j];
                j++;
            }
            if(j==nums.length && sum < target){
                break;
            }
            while (i<j && sum >= target) {
                sum -= nums[i];
                ++i;
            }
            if(sum + nums[i-1] >= target){
                res = Math.min(res, j-i+1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
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

        int[] nums = {1,1,1,1,1,1,1,1};
        int[] nums2 = {2,3,1,2,4,3};
        int[] nums3 = {1,2,3,4,5};
        int res = new MinimumSizeSubarraySum().minSubArrayLen(11, nums);
        System.out.println(res);
        res = new MinimumSizeSubarraySum().minSubArrayLen(7, nums2);
        System.out.println(res);
        res = new MinimumSizeSubarraySum().minSubArrayLen(15, nums3);
        System.out.println(res);
    }
}
