package com.company;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Utils {
    public static void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void printSet (Set set){
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(Arrays.toString((int[]) iterator.next()));
        }
    }

    public static void print2d (int[][] mtx){
        for(int[] a : mtx)
            System.out.println(Arrays.toString(a));
    }

    public static Character getch(String s,  int i){
        return s.charAt(i);
    }
}
