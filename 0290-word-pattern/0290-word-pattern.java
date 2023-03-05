// Time Complexity : O(n) where n is the length of the string s
// Space Complexity : O(n) Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Maintain a hashmap of character mappings


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        if( pattern.length() != n ) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i < n; i++ ) {
            char a = pattern.charAt(i);
            String b = arr[i];
            if( map.containsKey(a) ) {
                String c = map.get(a);
                if( !b.equals(c) ) {
                    return false;
                }
            } else {
                if( map.containsValue(b) ) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }
}