// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        int idx = 0;
        int taxableIncome = 0;
        int prev = 0;
        while( income > 0 ) {
            int[] curBracket = brackets[idx];
            double percent = curBracket[1]/100.0;
            int upper = curBracket[0];
            if( idx == brackets.length-1) {
                result = result + income*percent;
                return result;
            }
            taxableIncome = Math.min(income, upper - prev);
            result += taxableIncome*percent;
            prev = upper;
            income = income - taxableIncome;
            idx++;
        }
        return result;
    }
}