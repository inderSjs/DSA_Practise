class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if( map.containsKey(c1) ) {
                char c3 = map.get(c1);
                if( c2 != c3 ) {
                    return false;
                }
            } else {
                if( map.containsValue(c2) ) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }
}