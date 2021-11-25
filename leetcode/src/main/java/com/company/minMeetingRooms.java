package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// #253
public class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> twoEnds = new TreeMap<Integer, Integer>();

        for(int[] meeting : intervals){
            int st=meeting[0], end=meeting[1];
            twoEnds.put(st, twoEnds.getOrDefault(st,0)+1);
            twoEnds.put(end, twoEnds.getOrDefault(end,0)-1);
        }

        int cur=0, maxRm=0;
        for(Integer time: twoEnds.keySet()){
            Integer cnt = twoEnds.get(time);
            cur += cnt;
            maxRm = Math.max(maxRm, cur);
        }
        return maxRm;
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
        int[][] mtx = {{13,15},{1,13}};
        int[][] mtx2 = {{9,10},{4,9},{4,17}};

        int i = new minMeetingRooms().minMeetingRooms(mtx);
        System.out.println(i);
        i = new minMeetingRooms().minMeetingRooms(mtx2);
        System.out.println(i);
    }
}
