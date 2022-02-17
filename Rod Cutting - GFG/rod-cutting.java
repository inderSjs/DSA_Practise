// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    int[][] t;
    public int cutRod(int price[], int n) {
        //code here
        int len = price.length;
        int[] length = new int[n];
        for(int i = 0; i < len; i++) {
            length[i] = i+1;
        }
        t = new int[n+1][n];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < n; j++) {
                t[i][j] = -500;
            }
        }
        return maxProfit(price, length, n, n-1);
    }
    
    public int maxProfit(int price[], int length[], int rod_length, int n) {
        if( n < 0 || rod_length == 0 ) {
            return 0;
        }
        if( t[rod_length][n] != -500 ) {
            return t[rod_length][n];
        }
        if( length[n] <= rod_length ) {
            t[rod_length][n] = Math.max( price[n] + maxProfit(price, length, rod_length - length[n], n), maxProfit(price, length, rod_length, n-1));
            return t[rod_length][n];
        } else {
            t[rod_length][n] = maxProfit(price, length, rod_length, n-1);
            return t[rod_length][n];
        }
    }
}