class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0l, 0l, "");
        return result;
    }
    
    private void helper(String num, int target, int pivot, long calc, long tail, String expression) {
        //base case
        if( pivot == num.length() ) {
            if( calc == target ) {
                result.add(expression);
            }
            return;
        }
        
        //logic
        for(int i = pivot; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if( i != pivot && num.charAt(pivot) == '0') {
                continue;
            }
            if( pivot == 0 ) {
                helper(num, target, i+1, curr, curr, expression+curr);
            } else {
                helper(num, target, i+1, calc+curr, curr, expression + "+" + curr);
                helper(num, target, i+1, calc-curr, -curr, expression +"-" +curr);
                helper(num, target, i+1, calc-tail + (curr*tail), curr*tail, expression +"*" +curr);
            }
        }
    }
}