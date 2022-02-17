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
        int[] length = new int[n];
        for(int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        t = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if( i == 0 ) {
                    t[i][j] = 0;
                }
                if( j == 0 ) {
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if( length[i-1] <= j ) {
                    t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][n];
    }
    
}