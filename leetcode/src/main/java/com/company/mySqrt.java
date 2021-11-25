package com.company;

import java.util.Arrays;

// 69
public class mySqrt {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        if(x < 3) return x/2;
        int l = 1, r = x/2 + 1; // [l, r)
        while (l + 1 < r){
            int mid = l + (r-l)/2;
            System.out.println(Arrays.asList(l, r, mid));
            if(mid * mid <= x)
                l = mid;
            else
                r = mid;
        }
        return l;
    }

    public double mySqrt(double x, double delta) {
        if(x > 1){
            double left = 1, right = x/2;
            while (true){
                double mid = left + (right - left)/2;
                if(Math.abs(mid * mid - x) < delta)
                    return mid;
                if(mid * mid < x)
                    left = mid;
                else
                    right = mid;
            }
        }
        return 0;
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

        System.out.println(new mySqrt().mySqrt(111));
        System.out.println((int)Math.sqrt(111));
        System.out.println(new mySqrt().mySqrt(6.8, 0.01));
        System.out.println(Math.sqrt(6.8));
    }
}
