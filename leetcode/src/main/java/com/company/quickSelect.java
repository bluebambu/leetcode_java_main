package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class quickSelect {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int i, int j) {
        // range [  )
        if (i >= j)
            return;
        int p = arr[i];
        int k = i+1, end = j;
        while (k<j){
            while (k<j && arr[k] <= p) ++k;
            while (k<j && arr[j-1] >=p) --j;
            if(k>=j){
                swap(arr, i, k-1);
                sort(arr, i, k-1);
                sort(arr, k, end);
                return;
            }
            swap(arr, k, j-1);
        }
    }

    public static final void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        int[] ints = {1, 4, 2, -1, 18, 8};
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

        quickSelect.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
