class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char a = s.charAt(i);
            if( map.containsKey(a) ) {
                int count = map.get(a);
                map.put(a, count+1);
            } else {
                map.put(a, 1);
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            char b = s.charAt(i);
            if( !map.containsKey(b) ) {
                continue;
            }
            int x = map.get(b);
            if( x % 2 == 0) {
                result = result + x;
                map.remove(b);
            } else {
                if( x != 1) {
                    result = result + (x-1);
                    map.put(b, 1);
                }
            }
        }
        if( map.isEmpty() ) {
            return result;
        }
        return result+1;
    }
}