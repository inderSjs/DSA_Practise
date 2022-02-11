class Solution {
    public int addDigits(int num) {
        int sum = 0;
        int x = num;
        boolean bool = true;
        while( bool ) {
            x = helper(x);
            if( x < 10 ) {
                bool = false;
            }
        }
        return x;
    }
    
    public int helper(int x) {
        int sum = 0;
        while( x > 0 ) {
            int temp = x%10;
            sum = sum + temp;
            x = x/10;
        }
        return sum;
    }
}