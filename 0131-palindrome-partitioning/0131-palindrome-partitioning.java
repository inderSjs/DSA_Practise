class Solution {
    List<List<String>> temp;
    public List<List<String>> partition(String s) {
        temp = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return temp;
        // List<List<String>> result = new ArrayList<>();
        // for(int i = 0; i < temp.size(); i++) {
        //     boolean bool = true;
        //     for(int j = 0; j < temp.get(i).size(); j++) {
        //         if( !isPalindrome(temp.get(i).get(j))) {
        //             bool = false;
        //         }
        //     }
        //     if( bool ) {
        //         result.add(temp.get(i));
        //     }
        // }
        // return result;
    }
    
    private void helper(String s, int pivot, List<String> list) {
        // base case
        if( pivot == s.length() ) {
            temp.add(new ArrayList<>(list));
            return;
        }
        
        //logic
        for(int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i+1);
            if( isPalindrome(sub)) {
                list.add(sub);
                helper(s, i+1, list);
                list.remove(list.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String str) {
        int len = str.length();
        if( len == 1) {
            return true;
        }
        int i = 0;
        int j = len -1;
        while( i <= j ) {
            if( str.charAt(i) != str.charAt(j) ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}