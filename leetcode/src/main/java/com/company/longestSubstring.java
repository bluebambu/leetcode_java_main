package com.company;

import java.util.HashMap;

// 395
public class longestSubstring {
    public int longestSubstring_395(String s, int k) {
        return check(s, 0, s.length(), k);
    }

    private int check(String s, int start, int end, int k) {
        if(end < k) return 0;
        int[] charCnt = new int[26];
        for(int i=start; i<end; ++i){
            charCnt[s.charAt(i) - 'a'] += 1;
        }
        int mid = start;
        for(;mid<end; ++mid){
            if(charCnt[s.charAt(mid)-'a'] >= k)
                continue;
            int midNext = mid + 1;
            while (midNext<end && charCnt[s.charAt(midNext) -'a'] < k)
                midNext++;
            return Math.max(check(s, start, mid, k), check(s, midNext, end, k));
        }
        return end-start;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 5, 8};
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

    }
}
