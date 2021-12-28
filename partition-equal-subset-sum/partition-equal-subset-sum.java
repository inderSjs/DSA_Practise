class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if( sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        int n = nums.length;
        int[][] t = new int[n+1][target+1];
        boolean[][] bool = new boolean[n+1][target+1];
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
                if( j == 0) {
                    bool[i][j] = true;
                } else if ( i == 0) {
                    bool[i][j] = false;
                }
            }
        }
        /*for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                if( j == 0) {
                    t[i][j] = true;
                }
                if( i == 0 ) {
                    t[i][j] = false;
                }
            }
        } 
        t[0][0] = true; */
        return helper(nums, target, nums.length, t, bool);
        /*System.out.println(t.length);
        System.out.println(t[0].length);
        for(int i = 1; i < t.length; i++) {
            for(int j = 1; j < t[0].length; j++) {
                if( nums[i-1] < j) {
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                System.out.println(t[i][j]);
            }
        }
        return t[n][target]; */
    }
    
    public boolean helper(int[] arr, int target, int n, int[][] t, boolean[][] bool) {
        //System.out.println(arr);
        if( target == 0) {
            return true;
        }
        if( n == 0) {
            return false;
        }
        
        if( arr[n-1] <= target) {
            if( t[n][target] != -1) {
                return bool[n][target];
            } else {
                bool[n][target] =  helper(arr, target - arr[n-1], n-1, t, bool) || helper(arr, target, n-1, t, bool);
                t[n][target] = 100;
                return bool[n][target];
            }
            
        } else {
            if( t[n][target] != -1) {
                return bool[n][target];
            } else {
                bool[n][target] =  helper(arr, target, n-1, t, bool);
                t[n][target] = 100;
                return bool[n][target];
            }
        }
    }
}