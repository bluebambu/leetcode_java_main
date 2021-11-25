package com.company;

// #3
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[256];
        int i=0, j=0, res=0, cur=0, len=s.length(); // [)
        while (true){
            while (j<len){
                int idx = s.charAt(j);
                if(cnt[idx]>0)
                    break;
                cnt[idx] ++;
                j++;
            }
            res = Math.max(res, j-i);
            if(j==len){
                break;
            }
            char todel = s.charAt(j);
            while (i<j){
                int idx = s.charAt(i);
                cnt[idx]--;
                i++;
                if(s.charAt(i-1) == todel)
                    break;
            }
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
        String s = "abcabcbb";
    }
}
