class Solution {
    boolean[][] t;
    public int lastStoneWeightII(int[] stones) {
        int a = stones.length;
        int sum = 0;
        for(int i = 0; i < a; i++) {
            sum = sum + stones[i];
        }
        t = new boolean[a+1][sum+1];
        for(int i = 0; i <= a; i++) {
            for(int j = 0; j <= sum; j++) {
                if( i == 0 ) {
                    t[i][j] = false;
                }
                if( j == 0 ) {
                    t[i][j] = true;
                }
            }
        }
        t[0][0] = true;
        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= sum; j++) {
                if( stones[i-1] <= j) {
                    t[i][j] = t[i-1][j - stones[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        //sum = sum/2;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < t[0].length; i++) {
            if( t[a][i] == true ) {
                list.add(i);
            }
        }
     /*for(int i = 0 ; i < list.size(); i++) {
            System.out.println(list.get(i));
        } */
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= (list.size()/2); i++) {
            if( min > ( sum - (2*list.get(i)))) {
                min = sum - (2*list.get(i));
            }
        }
        return min*(-1);
    }
    
    public boolean helper(int[] arr, int target, int n) {
        if( target == 0 && n >= 0 ) {
            return true;
        }
        if( n < 0 ) {
            return false;
        }
        if( arr[n] <= target ) {
            return helper(arr, target - arr[n], n-1) || helper(arr, target, n-1);
        } else {
            return helper(arr, target, n-1);
        }
    }
}