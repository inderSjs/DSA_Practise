class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if( nl > hl) {
            return -1;
        }
        for(int i = 0; i <= hl-nl; i++) {
            for(int j = 0; j < nl; j++) {
                if( needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
                if( j == nl-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}