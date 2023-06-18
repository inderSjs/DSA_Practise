class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, 0, n);
        // System.out.println(result.toString());
        return result;
    }
    
    private void helper(StringBuilder curr, int cntOpen, int cntClose, int n) {
        if( curr.length() == (2 * n)) {
            result.add(curr.toString());
            return;
        }
            if( cntOpen < n ) {
                curr.append('(');
                helper(curr, cntOpen+1, cntClose, n);
                curr.deleteCharAt(curr.length()-1);
            }
            
            if( cntClose < n && cntClose < cntOpen) {
                curr.append(')');
                helper(curr, cntOpen, cntClose+1, n);
                curr.deleteCharAt(curr.length()-1);
            }
    }
}