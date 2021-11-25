package com.company;


import com.google.common.collect.Multiset;

import java.util.*;

// 218#
public class getSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<int[]> lines = new ArrayList<>();
        for(int[] b : buildings){
            int l=b[0], r=b[1], h=b[2];
            lines.add(new int[]{l, h, 1});
            lines.add(new int[]{r, h, -1});
        }

        Collections.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else {
                    if(o1[2] != o2[2])
                        return o2[2] - o1[2];
                    else if(o1[2]>0)
                        return o2[1] - o1[1];
                    else
                        return o1[1] - o2[1];
                }
            }
        });

        lines.forEach(f->{
            System.out.println(Arrays.toString(f));
        });

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for(int[] l : lines){
            int x=l[0], y=l[1], f=l[2];
            if(f==1){
                if(pq.size() == 0 || y > pq.peek())
                    res.add(Arrays.asList(x,y));
                pq.add(y);
            }else {
                Integer peek = pq.peek();
                pq.remove(y);
                if (!peek.equals(pq.peek()))
                    res.add(Arrays.asList(x, pq.peek()));
            }
        }
        return res;
    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> lines = new ArrayList<>();
        for(int[] b : buildings){
            int l=b[0], r=b[1], h=b[2];
            lines.add(Arrays.asList(l, h));
            lines.add(Arrays.asList(r, -h));
        }

        Collections.sort(lines, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        return null;
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

        int[][] mtx = {{0,2,3},{2,5,3}};
        List<List<Integer>> skyline = new getSkyline().getSkyline(mtx);
        System.out.println(skyline);
        System.out.println();

        mtx = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        skyline = new getSkyline().getSkyline(mtx);
        System.out.println(skyline);
        System.out.println();

        mtx = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        skyline = new getSkyline().getSkyline(mtx);
        System.out.println(skyline);
    }
}
