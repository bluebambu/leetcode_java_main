package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int nc = coins.length;
        int[][] dp = new int[nc][amount + 1];

        // init first row
        dp[0][0] = 0;
        for(int j=1; j<amount+1; ++j){
            if(j % coins[0] == 0)
                dp[0][j] = j/coins[0];
            else
                dp[0][j] = -1;
        }


        for(int i=1; i<nc; i++){
            for(int j=1; j<amount+1; j++){
                int curNoChoose = dp[i-1][j];
                int curChoose = (j>=coins[i] && dp[i][j-coins[i]] != -1) ? dp[i][j-coins[i]] + 1 : -1;
                if(curChoose == -1 && curNoChoose == -1)
                    dp[i][j] = -1;
                else if(curChoose == -1 || curNoChoose == -1)
                    dp[i][j] = Math.max(curChoose, curNoChoose);
                else
                    dp[i][j] = Math.min(curChoose, curNoChoose);
            }
        }

        Utils.print2d(dp);

        return dp[nc-1][amount];
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

        String s = "wreiuy/.,ASDFE";

        coinChange coinChange = new coinChange();
        int[] nums = {1, 2,5};
        int amount = 11;
        System.out.println(coinChange.coinChange(nums, amount));
        int[] nums2 = {2, 5, 10, 1};
        amount = 27;
        System.out.println(coinChange.coinChange(nums2, amount));
        int[] nums3 = {1, 2, 3, 4, 5};

    }
}
