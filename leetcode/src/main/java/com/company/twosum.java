package com.company;

import java.util.Arrays;

public class twosum {
    public int twoSum(int[] list, int tgt) {
        return 0;
    }

    public int[] twoSum2ptr(int[] list, int tgt) {
        Arrays.sort(list);
        int i=0, j=list.length - 1;
        while (i < j) {
            if(list[i] + list[j] == tgt) {
                return new int[]{i, j}; // here it is new index, not old index any more.
            }

            if(list[i] + list[j] < tgt) {
                i++;
            }else {
                j++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 5, 8};
        twosum ts = new twosum();
        int[] i = ts.twoSum2ptr(ints, 9);
        System.out.println(Arrays.toString(i));
    }
}
