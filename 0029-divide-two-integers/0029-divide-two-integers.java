class Solution {
    public int divide(int dividend, int divisor) {
        if( divisor == 0 ) {
            return Integer.MAX_VALUE;
        }
        if( dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if( divisor == 1) {
            return dividend;
        }
        int result = 0;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        // int shifts = 0;
        while( ldividend >= ldivisor) {
            int shifts = 0;
            while( ldividend >= (ldivisor<<shifts) ) {
                shifts++;
            }
            shifts--;
            ldividend = ldividend - (ldivisor<<shifts);
            result = result + (int)Math.pow(2,shifts);
        }
        if( (divisor > 0 && dividend >= 0) || (divisor < 0 && dividend < 0) ) {
            return result;
        }
        return -1*result;
    }
}