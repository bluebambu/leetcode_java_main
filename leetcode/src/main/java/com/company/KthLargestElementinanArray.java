package com.company;

import static com.company.Utils.swap;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length, k);
    }
    int find(int[] nums, int st, int end, int k) {
        int pivot = nums[st], i=st+1, j=end;
        while (i<j){
            while (i<j && nums[i] <= pivot) ++i;
            while (i<j && nums[j-1] >= pivot) --j;
            if(i>=j)
                break;
            swap(nums, i, j-1);
        }
        swap(nums, st, i-1);
        if(i-1 == nums.length-k)
            return nums[i-1];
        if(i-1 < nums.length-k)
            return find(nums, i, end, k);
        else
            return find(nums, st, i-1, k);
    }

    public static void main(String[] args) {
        int[] ints = {3,2,1,5,6,4};
        int k = 2;

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

        int kthLargest = new KthLargestElementinanArray().findKthLargest(ints, k);
        System.out.println(kthLargest);
    }
}
