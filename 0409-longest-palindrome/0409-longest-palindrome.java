class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char a = s.charAt(i);
            if( set.contains(a) ) {
                count = count + 2;
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        if( set.isEmpty() ) {
            return count;
        } else {
            return count+1;
        }
    }
}